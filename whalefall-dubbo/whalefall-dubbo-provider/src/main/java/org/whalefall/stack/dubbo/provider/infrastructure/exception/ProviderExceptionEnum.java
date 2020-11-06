package org.whalefall.stack.dubbo.provider.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.whalefall.stack.framework.exception.assertion.BizExceptionAssert;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description dubbo provider异常信息
 * @create 2020/7/3 9:19 上午
 */
@Getter
@AllArgsConstructor
public enum ProviderExceptionEnum implements BizExceptionAssert {
    DO_NOT_EXIT(20001, "查询不存在")
    ;
    private int code;
    private String message;
}
