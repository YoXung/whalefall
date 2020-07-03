package org.whalefall.stack.dubbo.provider.domain.demo.repository;

import org.whalefall.stack.dubbo.provider.infrastructure.repository.persistence.DemoPO;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 仓储接口
 * @create 2020/7/3 9:04 上午
 */
public interface DemoRepository {
    DemoPO findByName(String name);
}
