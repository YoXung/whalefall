package org.whalefall.stack.framework.exception.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/5/28 3:22 下午
 */
@Configuration
@PropertySource("classpath:rpc.properties")
public class DubboConfiguration {
}
