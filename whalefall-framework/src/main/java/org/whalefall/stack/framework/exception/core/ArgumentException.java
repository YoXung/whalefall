package org.whalefall.stack.framework.exception.core;

import org.whalefall.stack.framework.exception.enums.BaseResponseEnum;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 参数异常
 * @create 2020/5/27 10:24 上午
 */
public class ArgumentException extends BaseException {
    public ArgumentException(BaseResponseEnum baseResponseEnum, Object[] args, String message) {
        super(baseResponseEnum, args, message);
    }

    public ArgumentException(BaseResponseEnum baseResponseEnum, Object[] args, String message, Throwable cause) {
        super(baseResponseEnum, args, message, cause);
    }
}
