package com.example.service.conditional_bean_loading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Slf4j
@Service
public class BeanUserService {

    @Autowired
    private MyService myService;

    public void test(){
        myService.performTask();
    }
}
