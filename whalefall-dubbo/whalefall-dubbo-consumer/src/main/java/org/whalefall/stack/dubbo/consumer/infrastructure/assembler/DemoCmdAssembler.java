package org.whalefall.stack.dubbo.consumer.infrastructure.assembler;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.whalefall.stack.dubbo.api.provider.command.cmd.DemoCmd;
import org.whalefall.stack.dubbo.consumer.ui.viewobject.ConsumerVO;

import java.util.function.Function;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description 装配器
 * @create 2020/6/29 4:29 下午
 */
@Component
public class DemoCmdAssembler implements Function<ConsumerVO, DemoCmd> {
    @Override
    public DemoCmd apply(ConsumerVO consumerVO) {
        DemoCmd demoCmd = new DemoCmd();
        BeanUtils.copyProperties(consumerVO, demoCmd);
        return demoCmd;
    }
}
