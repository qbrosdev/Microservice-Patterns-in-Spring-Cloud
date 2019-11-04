package com.example.actuator;


import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Slf4j
@Component
//path will be actuator/mypoint
@Endpoint(id = "mypoint")
public class CustomEndPoint {

    /**
     * @param value this value is automatically mapped to a GET request query parameter: actuator/mypoint?value=X
     *              you need to run spring with java compiler -parameter option (this option allows actuator to read parameters)
     *              this value is {@link Nullable} so it can exist in the query or not
     * @return Sting passed as json
     */
    @ReadOperation
    public Result echo(@Nullable String value) {
        return Result.builder()
                .echoValue(value)
                .build();
    }

    /**
     * @param arg0 because of using {@link Selector} the method parameter is mapped into URL
     * @return Result
     * @see <a href="http://google.com">https://stackoverflow.com/questions/47920201/how-do-you-use-selector-in-writeoperation-in-spring-boot-2-0-actuator-endp</a>
     */
    @ReadOperation
    public Result echo2(@Selector String arg0) {
        return Result.builder()
                .echoValue(arg0)
                .build();
    }

    /**
     * Delete operation (http delete method) does not return any thing, in successful delete it will return HTTP 204 no-Content
     *
     * @param arg0 path var
     */
    @DeleteOperation
    public void doDelete(@Selector String arg0) {
        log.info("delete request came in for {}", arg0);
    }

    /**
     * {@link WriteOperation} maps to post method
     * @param arg0 path
     * @param content http post body is:
     * {
     * 	"content": "shittty body"
     * }
     */
    @WriteOperation
    public void doWrite(@Selector String arg0, @Nullable String content) {
        log.info("post request came in for {} and request body is {}", arg0, content);
    }

}

@Builder
class Result {
    private String echoValue;

    public String getEchoValue() {
        return echoValue;
    }

    public void setEchoValue(String echoValue) {
        this.echoValue = echoValue;
    }
}
