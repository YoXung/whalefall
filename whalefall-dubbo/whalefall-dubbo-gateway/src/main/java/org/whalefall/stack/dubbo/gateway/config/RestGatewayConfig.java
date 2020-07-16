package org.whalefall.stack.dubbo.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/7/16 7:56 下午
 */
@Configuration
public class RestGatewayConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
