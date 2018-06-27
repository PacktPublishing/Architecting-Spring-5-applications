package com.asimio.cloud.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("registration-first")
@Configuration
@EnableDiscoveryClient
public class EurekaClientConfiguration {

}