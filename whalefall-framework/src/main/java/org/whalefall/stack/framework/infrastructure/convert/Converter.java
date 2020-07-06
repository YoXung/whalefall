package org.whalefall.stack.framework.infrastructure.convert;

import java.util.function.Function;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 转换器
 * @create 2020/7/6 10:02 上午
 */
public interface Converter<A, B> {
    B doForward(A a);
    A doBackward(B b);
}
