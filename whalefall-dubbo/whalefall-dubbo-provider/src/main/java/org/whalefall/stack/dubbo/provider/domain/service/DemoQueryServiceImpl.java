package org.whalefall.stack.dubbo.provider.domain.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.whalefall.stack.dubbo.api.provider.query.dto.DemoDTO;
import org.whalefall.stack.dubbo.api.provider.query.facade.DemoQueryService;
import org.whalefall.stack.dubbo.api.provider.query.qry.DemoQry;
import org.whalefall.stack.dubbo.provider.domain.demo.aggregateroot.Demo;
import org.whalefall.stack.dubbo.provider.domain.demo.repository.DemoRepository;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description
 * @create 2020/7/3 9:17 上午
 */
@Service(interfaceClass = DemoQueryService.class)
public class DemoQueryServiceImpl implements DemoQueryService {
    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoDTO queryDemo(DemoQry demoQry) {
        return demoRepository.findByName(demoQry.getName());
    }
}
