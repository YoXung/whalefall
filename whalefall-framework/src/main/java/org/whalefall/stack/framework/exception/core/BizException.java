package org.whalefall.stack.framework.exception.core;

import org.whalefall.stack.framework.exception.enums.BaseResponseEnum;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description 业务异常
 * @create 2020/5/27 10:25 上午
 */
public class BizException extends BaseException {
    public BizException(BaseResponseEnum baseResponseEnum, Object[] args, String message) {
        super(baseResponseEnum, args, message);
    }

    public BizException(BaseResponseEnum baseResponseEnum, Object[] args, String message, Throwable cause) {
        super(baseResponseEnum, args, message, cause);
    }
}
