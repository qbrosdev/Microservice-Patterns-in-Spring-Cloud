package com.example.service;

import com.example.service.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * config changes on the config server will be reflected on on the @value
 * attributes in this bean
 */
@RefreshScope
@RestController
@Slf4j
public class Controller {

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private CustomerRepository customerRepository;
    /**
     * to update this value send an empty body post request to actuator/refresh endpoint
     */
    @Value("${key:defalut value}")
    private String value;


    /**
     * @see {https://www.baeldung.com/spring-profiles}
     */
    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @GetMapping("/value")
    public String showMessage() {
        log.info("request came---------------------------");
        return configProperties.toString();
    }

    @PostMapping("/newItem")
    public Customer create(@Valid @RequestBody Customer newCustomer){
        return customerRepository
                .save(Customer
                        .builder()
                        .customerName(newCustomer.getCustomerName())
                        .test(newCustomer.getTest())
                        .build());
    }
}
