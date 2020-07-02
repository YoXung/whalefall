package org.whalefall.stack.dubbo.provider.domain.service;

import org.apache.dubbo.config.annotation.Service;
import org.whalefall.stack.dubbo.api.provider.command.cmd.DemoCmd;
import org.whalefall.stack.dubbo.api.provider.command.facade.DemoCommandService;
import org.whalefall.stack.dubbo.provider.domain.demo.aggregateroot.Demo;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/29 4:50 下午
 */
@Service(interfaceClass = DemoCommandService.class)
public class DemoDomainService implements DemoCommandService {
    @Override
    public int createDemo(DemoCmd demoCmd) {
        Demo demo = Demo.builder()
                .id(demoCmd.getId())
                .name(demoCmd.getName())
                .build();
        return
        return 0;
    }
}
