package org.whalefall.stack.framework.infrastructure.exception.assertion;

import org.whalefall.stack.framework.infrastructure.enums.BaseResponseEnum;
import org.whalefall.stack.framework.infrastructure.exception.BaseException;
import org.whalefall.stack.framework.infrastructure.exception.CommonException;

import java.text.MessageFormat;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 通用异常断言
 * @create 2020/5/27 11:09 上午
 */
public interface CommonExceptionAssert extends BaseExceptionAssert, BaseResponseEnum {
    @Override
    default BaseException newException(Object... args) {
        String message = MessageFormat.format(this.getMessage(), args);
        return new CommonException(this, args, message);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String message = MessageFormat.format(this.getMessage(), args);
        return new CommonException(this, args, message, t);
    }
}
