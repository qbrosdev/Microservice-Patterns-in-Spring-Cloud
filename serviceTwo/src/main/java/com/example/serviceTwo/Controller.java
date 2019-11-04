package com.example.serviceTwo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@RefreshScope
@RestController
@Slf4j
public class Controller {

    @Autowired
    protected RestTemplate restTemplate;
    private final String API_BASE_URL = "http://service-one";

    /**
     * contains information retrived form eureka server
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${key:defalut value}")
    private String value;


    @GetMapping("/value")
    public void callService(){
        String result = restTemplate.getForObject(API_BASE_URL + "/value", String.class);
        log.info(result);
    }
}
