package org.whalefall.stack.common.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 跨域
 * @create 2020/9/4 11:22 上午
 */
@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui")
                .resourceChain(false);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui/").setViewName("forward:/swagger-ui/index.html");
    }
}
