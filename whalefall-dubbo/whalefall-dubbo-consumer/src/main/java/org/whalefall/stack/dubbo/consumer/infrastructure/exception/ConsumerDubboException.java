package org.whalefall.stack.dubbo.consumer.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.whalefall.stack.framework.exception.assertion.BizExceptionAssert;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description 消费端异常
 * @create 2020/7/2 7:29 下午
 */
@Getter
@AllArgsConstructor
public enum ConsumerDubboException implements BizExceptionAssert {
    CONSUMER_DUBBO_EXCEPTION_TEST(1001, "dubbo消费端异常测试"),
    ;
    private int code;
    private String message;
}
