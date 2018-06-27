package com.asimio.cloud.config;

import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Profile("config-monitor")
@Configuration
@Import(RabbitAutoConfiguration.class)
public class ConfigMonitorConfiguration {

}

//@HystrixCommand(fallbackMethod=„”)
//public Article getArticle(String id) {
//	// call external system
//}