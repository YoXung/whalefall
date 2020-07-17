package org.whalefall.stack.dubbo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "org.whalefall.stack.dubbo.gateway.core")
public class WhalefallDubboGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhalefallDubboGatewayApplication.class, args);
    }
    
}
