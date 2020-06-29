package org.whalefall.stack.dubbo.api.provider.command.cmd;

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/29 4:32 下午
 */
@Data
public class DemoCmd implements Serializable {
    private long id;
    private String name;
}
