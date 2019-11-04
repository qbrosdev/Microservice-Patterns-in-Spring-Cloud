package com.example.service;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        UUID requestId = UUID.randomUUID();
        MDC.clear();
        MDC.put("requestId", String.valueOf(requestId));
        return true;
    }

}
