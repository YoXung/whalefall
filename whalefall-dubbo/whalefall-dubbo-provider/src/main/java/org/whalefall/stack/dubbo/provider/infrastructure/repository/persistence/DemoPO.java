package org.whalefall.stack.dubbo.provider.infrastructure.repository.persistence;

import lombok.Builder;
import lombok.Data;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description 持久化对象
 * @create 2020/7/3 9:06 上午
 */
@Data
@Builder
public class DemoPO {
    private long id;
    private String name;
}
