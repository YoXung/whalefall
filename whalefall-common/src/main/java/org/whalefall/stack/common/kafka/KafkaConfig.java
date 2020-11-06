package org.whalefall.stack.common.kafka;

import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description kafka配置
 * @create 2020/10/13 11:39 上午
 */
@Configuration
@PropertySource("classpath:kafka.properties")
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String kafka_servers;

    @Bean
    public KafkaAdminClient kafkaAdminClient() {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafka_servers);
        return (KafkaAdminClient) KafkaAdminClient.create(props);
    }
}
