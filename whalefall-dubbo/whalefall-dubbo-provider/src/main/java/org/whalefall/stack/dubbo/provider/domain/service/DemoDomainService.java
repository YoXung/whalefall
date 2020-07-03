package org.whalefall.stack.dubbo.provider.domain.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.whalefall.stack.dubbo.api.provider.command.cmd.DemoCmd;
import org.whalefall.stack.dubbo.api.provider.command.facade.DemoCommandService;
import org.whalefall.stack.dubbo.provider.domain.demo.aggregateroot.Demo;
import org.whalefall.stack.dubbo.provider.domain.demo.repository.DemoRepository;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/29 4:50 下午
 */
@Service(interfaceClass = DemoCommandService.class)
public class DemoDomainService implements DemoCommandService {
    @Autowired
    private DemoRepository demoRepository;

    @Override
    public int createDemo(DemoCmd demoCmd) {
        Demo demo = Demo.builder()
                .id(demoCmd.getId())
                .name(demoCmd.getName())
                .build();
        return 0;
    }
}
