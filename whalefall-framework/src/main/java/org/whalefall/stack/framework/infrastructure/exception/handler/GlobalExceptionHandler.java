package org.whalefall.stack.framework.infrastructure.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.whalefall.stack.framework.infrastructure.enums.ArgumentResponseEnum;
import org.whalefall.stack.framework.infrastructure.enums.CommonResponseEnum;
import org.whalefall.stack.framework.infrastructure.enums.ServletResponseEnum;
import org.whalefall.stack.framework.infrastructure.exception.BaseException;
import org.whalefall.stack.framework.infrastructure.exception.BizException;
import org.whalefall.stack.framework.infrastructure.i18n.GlobalMessageSource;
import org.whalefall.stack.framework.ui.vo.ER;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 全局异常处理
 * @create 2020/5/27 9:09 上午
 */
@Component
@RestControllerAdvice
@ConditionalOnWebApplication
@ConditionalOnMissingBean(value = GlobalExceptionHandler.class)
@Slf4j
public class GlobalExceptionHandler {
    // 生产环境
    private final static String ENV_PROD = "prod";

    @Autowired
    private GlobalMessageSource globalMessageSource;
    // 当前环境
    @Value(value = "${spring.profiles.active}")
    private String profile;

    /*
     * 主要处理三类异常
     * 1、Server：自定义异常
     * 2、Servlet：servlet、bind、valid
     * 3、Unknown：数据库异常
     */

    /**
     * 获取国际化消息
     *
     * @param e 异常
     * @return 异常信息
     */
    public String getMessage(BaseException e) {
        String code = "response." + e.getBaseResponseEnum().toString();
        String message = globalMessageSource.getMessage(code, e.getArgs());

        if (message == null || message.isEmpty()) {
            return e.getMessage();
        }

        return message;
    }

    /**
     * 业务异常
     *
     * @param e 业务异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BizException.class)
    public ER handleBizException(BizException e) {
        log.error(e.getMessage(), e);
        return new ER(e.getBaseResponseEnum().getCode(), getMessage(e));
    }

    /**
     * 自定义异常
     *
     * @param e 自定义异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseException.class)
    public ER handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);
        return new ER(e.getBaseResponseEnum().getCode(), getMessage(e));
    }

    /**
     * Servlet异常（Controller上一层相关异常）
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
            // BindException.class,
            // MethodArgumentNotValidException.class
    })
    public ER handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        int code = CommonResponseEnum.SERVER_ERROR.getCode();
        try {
            ServletResponseEnum servletExceptionEnum = ServletResponseEnum.valueOf(e.getClass().getSimpleName());
            code = servletExceptionEnum.getCode();
        } catch (IllegalArgumentException e1) {
            log.error("class [{}] not defined in enum {}", e.getClass().getName(), ServletResponseEnum.class.getName());
        }

        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如404.
            code = CommonResponseEnum.SERVER_ERROR.getCode();
            BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
            String message = getMessage(baseException);
            return new ER(code, message);
        }
        return new ER(code, e.getMessage());
    }

    /**
     * 参数绑定异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    public ER handleBindException(BindException e) {
        log.error("BindException", e);
        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 参数校验(Valid)异常，将校验失败的所有异常组合成一条错误信息
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ER handleValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 包装绑定异常结果
     *
     * @param bindingResult 绑定结果
     * @return 异常结果
     */
    private ER wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();
        System.out.println("++++++++++这里进来了");

        msg.append(bindingResult.getFieldErrors().size() > 0 ? "" : bindingResult.getAllErrors().get(0).getDefaultMessage());
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            msg.append(", ");
////            if (error instanceof FieldError) {
////                msg.append(((FieldError) error).getField()).append(": ");
////            }
//            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
//        }

        return new ER(ArgumentResponseEnum.VALID_ERROR.getCode(), msg.toString());
    }

    /**
     * 未定义异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = Exception.class)
    public ER handleException(Exception e) {
        log.error(e.getMessage(), e);

        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            int code = CommonResponseEnum.SERVER_ERROR.getCode();
            BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
            String message = getMessage(baseException);
            return new ER(code, message);
        }

        return new ER(CommonResponseEnum.SERVER_ERROR.getCode(), StringUtils.substringAfter(e.getMessage(), ":"));
    }
}
