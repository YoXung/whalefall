package org.whalefall.stack.framework.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description 服务器异常枚举
 * @create 2020/8/5 11:05 上午
 */
@Getter
@AllArgsConstructor
public enum ServletResponseEnum {
    MethodArgumentNotValidException(400, "", HttpServletResponse.SC_BAD_REQUEST),
    MethodArgumentTypeMismatchException(400, "", HttpServletResponse.SC_BAD_REQUEST),
    MissingServletRequestPartException(400, "", HttpServletResponse.SC_BAD_REQUEST),
    MissingPathVariableException(400, "", HttpServletResponse.SC_BAD_REQUEST),
    BindException(400, "",HttpServletResponse.SC_BAD_REQUEST),
    MissingServletRequestParameterException(400, "", HttpServletResponse.SC_BAD_REQUEST),
    TypeMismatchException(400, "", HttpServletResponse.SC_BAD_REQUEST),
    ServletRequestBindingException(400, "", HttpServletResponse.SC_BAD_REQUEST),
    HttpMessageNotReadableException(1400, "", HttpServletResponse.SC_BAD_REQUEST),
    NoHandlerFoundException(404, "", HttpServletResponse.SC_NOT_FOUND),
    NoSuchRequestHandlingMethodException(404, "", HttpServletResponse.SC_NOT_FOUND),
    HttpRequestMethodNotSupportedException(405, "", HttpServletResponse.SC_METHOD_NOT_ALLOWED),
    HttpMediaTypeNotAcceptableException(406, "", HttpServletResponse.SC_NOT_ACCEPTABLE),
    HttpMediaTypeNotSupportedException(415, "", HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE),
    ConversionNotSupportedException(500, "", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    HttpMessageNotWritableException(500, "", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    AsyncRequestTimeoutException(503, "", HttpServletResponse.SC_SERVICE_UNAVAILABLE)
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
