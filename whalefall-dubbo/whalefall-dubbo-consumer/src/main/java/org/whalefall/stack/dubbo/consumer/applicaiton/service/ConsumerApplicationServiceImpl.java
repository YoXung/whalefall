package org.whalefall.stack.dubbo.consumer.applicaiton.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whalefall.stack.dubbo.api.provider.command.cmd.DemoCmd;
import org.whalefall.stack.dubbo.api.provider.command.facade.DemoCommandService;
import org.whalefall.stack.dubbo.api.provider.query.dto.DemoDTO;
import org.whalefall.stack.dubbo.api.provider.query.facade.DemoQueryService;
import org.whalefall.stack.dubbo.api.provider.query.qry.DemoQry;
import org.whalefall.stack.dubbo.consumer.applicaiton.api.ConsumerApplicationService;
import org.whalefall.stack.dubbo.consumer.infrastructure.assembler.DemoCmdAssembler;
import org.whalefall.stack.dubbo.consumer.ui.viewobject.ConsumerVO;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/28 3:59 下午
 */
@Service
public class ConsumerApplicationServiceImpl implements ConsumerApplicationService {
    @Autowired
    private DemoCmdAssembler demoCmdAssembler;
    @Reference
    private DemoCommandService demoCommandService;
    @Reference
    private DemoQueryService demoQueryService;

    @Override
    public int createDemo(ConsumerVO consumerVO) {
        DemoCmd demoCmd = demoCmdAssembler.apply(consumerVO);
        return demoCommandService.createDemo(demoCmd);
    }

    @Override
    public DemoDTO queryByName(String name) {
        DemoQry demoQry = new DemoQry().setName(name);
        return demoQueryService.queryDemo(demoQry);
    }
}
