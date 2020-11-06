package org.whalefall.stack.framework.exception.core;

import org.whalefall.stack.framework.exception.enums.BaseResponseEnum;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description 通用异常
 * @create 2020/5/27 11:21 上午
 */
public class CommonException extends BaseException {
    public CommonException(BaseResponseEnum baseResponseEnum, Object[] args, String message) {
        super(baseResponseEnum, args, message);
    }

    public CommonException(BaseResponseEnum baseResponseEnum, Object[] args, String message, Throwable cause) {
        super(baseResponseEnum, args, message, cause);
    }
}
