package com.example.service.conditional_bean_loading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Service;

/**
 * https://stackoverflow.com/a/25790672/3593084
 */
@Service
@Slf4j
@ConditionalOnClass(name ="com.example.service.conditional_bean_loading.ConditionBeanOne")
public class MyServiceImplOne implements MyService {
    @Override
    public void performTask() {
        log.warn("MyServiceImplOne");
    }
}
