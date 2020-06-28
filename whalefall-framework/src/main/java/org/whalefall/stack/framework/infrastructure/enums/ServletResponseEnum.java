package org.whalefall.stack.framework.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 服务器异常枚举
 * @create 2020/5/27 9:43 上午
 */
@Getter
@AllArgsConstructor
public enum ServletResponseEnum {
    MethodArgumentNotValidException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    MethodArgumentTypeMismatchException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    MissingServletRequestPartException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    MissingPathVariableException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    BindException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    MissingServletRequestParameterException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    TypeMismatchException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    ServletRequestBindingException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    HttpMessageNotReadableException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    NoHandlerFoundException(1404, "", HttpServletResponse.SC_NOT_FOUND),
    NoSuchRequestHandlingMethodException(1404, "", HttpServletResponse.SC_NOT_FOUND),
    HttpRequestMethodNotSupportedException(1405, "", HttpServletResponse.SC_METHOD_NOT_ALLOWED),
    HttpMediaTypeNotAcceptableException(1406, "", HttpServletResponse.SC_NOT_ACCEPTABLE),
    HttpMediaTypeNotSupportedException(1415, "", HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE),
    ConversionNotSupportedException(1500, "", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    HttpMessageNotWritableException(1500, "", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    AsyncRequestTimeoutException(1503, "", HttpServletResponse.SC_SERVICE_UNAVAILABLE)
    ;

    /**
     * 返回码，目前与{@link #statusCode}相同
     */
    private int code;
    /**
     * 返回信息，直接读取异常的message
     */
    private String message;
    /**
     * HTTP状态码
     */
    private int statusCode;
}
