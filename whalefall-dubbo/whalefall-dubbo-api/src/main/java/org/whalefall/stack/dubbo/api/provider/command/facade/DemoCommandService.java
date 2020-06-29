package org.whalefall.stack.dubbo.api.provider.command.facade;

import org.whalefall.stack.dubbo.api.provider.command.cmd.DemoCmd;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/29 4:49 下午
 */
public interface DemoCommandService {
    int createDemo(DemoCmd demoCmd);
}
