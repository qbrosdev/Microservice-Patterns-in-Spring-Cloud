package com.example.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Component
public class DependencyProvider {

    /**
     *
     * @return a eureka enabled rest template
     */
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
           return new RestTemplate();
    }
}
