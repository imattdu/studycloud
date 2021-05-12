package com.matt.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author matt
 * @create 2021-05-07 19:48
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
