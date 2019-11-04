package com.example.service.conditional_bean_loading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Service;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Service
@Slf4j
@ConditionalOnClass(name ="com.example.service.conditional_bean_loading.ConditionBeanTwo")
public class MyServiceImplTwo implements MyService {
    @Override
    public void performTask() {
        log.warn("MyServiceImplTwo, this will be loaded conditionally");
    }
}
