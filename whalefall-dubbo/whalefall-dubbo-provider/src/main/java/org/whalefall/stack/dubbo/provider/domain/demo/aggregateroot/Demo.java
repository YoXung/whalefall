package org.whalefall.stack.dubbo.provider.domain.demo.aggregateroot;

import lombok.Builder;
import lombok.Data;
import org.whalefall.stack.framework.annotations.ddd.domain.AggregateRoot;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 聚合根
 * @create 2020/7/2 8:46 下午
 */
@AggregateRoot
@Data
@Builder
public class Demo {
    private long id;
    private String name;
    // 聚合根内部完成业务逻辑
}
