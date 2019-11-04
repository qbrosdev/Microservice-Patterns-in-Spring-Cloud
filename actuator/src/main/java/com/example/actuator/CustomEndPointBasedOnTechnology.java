package com.example.actuator;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@EndpointWebExtension(endpoint = CustomEndPoint.class)
public class CustomEndPointBasedOnTechnology {

    // https://www.youtube.com/watch?v=otcYECeFS6Y
    @ReadOperation
    public WebEndpointResponse<Result> getShit(){
       return  new WebEndpointResponse<>();
    }
}
