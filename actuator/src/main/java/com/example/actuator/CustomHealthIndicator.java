package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Created by QBros on Zero Hour ... Hooah!
 * address: actuator/health
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.status(Status.DOWN).withException(new RuntimeException()).build();
    }
}
