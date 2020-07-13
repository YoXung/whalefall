package org.whalefall.stack.dubbo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ServletComponentScan(basePackages = "org.whalefall.stack.dubbo.gateway.core")
public class WhalefallDubboGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhalefallDubboGatewayApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
