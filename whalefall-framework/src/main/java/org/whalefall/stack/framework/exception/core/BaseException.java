package org.whalefall.stack.framework.exception.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.whalefall.stack.framework.exception.enums.BaseResponseEnum;

import java.io.Serializable;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 异常基类
 * @create 2020/5/27 10:21 上午
 */
@Getter
@NoArgsConstructor
public class BaseException extends RuntimeException implements Serializable {
    // 返回码
    protected BaseResponseEnum baseResponseEnum;
    // 异常消息参数
    protected transient Object[] args;

    public BaseException(BaseResponseEnum baseResponseEnum) {
        super(baseResponseEnum.getMessage());
        this.baseResponseEnum = baseResponseEnum;
    }

    public BaseException(int code, String message) {
        super(message);
        this.baseResponseEnum = new BaseResponseEnum() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }

    public BaseException(BaseResponseEnum baseResponseEnum, Object[] args, String message) {
        super(message);
        this.baseResponseEnum = baseResponseEnum;
        this.args = args;
    }

    public BaseException(BaseResponseEnum baseResponseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.baseResponseEnum = baseResponseEnum;
        this.args = args;
    }
}
