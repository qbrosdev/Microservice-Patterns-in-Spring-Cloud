package com.example.service.conditional_bean_loading;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanUserServiceTest {

    @Autowired
    private BeanUserService beanUserService;

    @Test
    public void test1() {
        beanUserService.test();
    }
}