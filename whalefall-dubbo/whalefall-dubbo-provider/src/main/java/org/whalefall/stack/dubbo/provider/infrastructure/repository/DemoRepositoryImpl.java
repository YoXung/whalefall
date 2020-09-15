package org.whalefall.stack.dubbo.provider.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.whalefall.stack.dubbo.api.provider.query.dto.DemoDTO;
import org.whalefall.stack.dubbo.provider.domain.demo.repository.DemoRepository;
import org.whalefall.stack.dubbo.provider.infrastructure.convertor.DemoConvertor;
import org.whalefall.stack.dubbo.provider.infrastructure.exception.ProviderExceptionEnum;
import org.whalefall.stack.dubbo.provider.infrastructure.repository.mapper.DemoMapper;
import org.whalefall.stack.dubbo.provider.infrastructure.repository.persistence.DemoPO;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 仓储类实现
 * @create 2020/7/3 9:07 上午
 */
@Repository
public class DemoRepositoryImpl implements DemoRepository {
    @Autowired(required = false)
    private DemoMapper demoMapper;

    @Override
    public DemoDTO findByName(String name) {
        //DemoPO demoPO = demoMapper.selectByName(name);
        DemoPO demoPO = null;
        ProviderExceptionEnum.DO_NOT_EXIT.assertNotNull(demoPO);
        return DemoConvertor.toDemoDTO(demoPO);
    }
}
