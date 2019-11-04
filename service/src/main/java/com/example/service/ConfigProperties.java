package com.example.service;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.util.List;

/**
 * https://www.baeldung.com/configuration-properties-in-spring-boot
 * https://www.mkyong.com/spring-boot/spring-boot-configurationproperties-example/
 */

//Note: If we don't use @Configuration in the POJO, then we need to add
// @EnableConfigurationProperties(ConfigProperties.class) in the main Spring application
// class to bind the properties into the POJO.
@Configuration


//We also use @PropertySource to define the location of our properties file. Otherwise,
// Spring uses the default location (classpath:application.properties).
//NOTE: if we want to use default properties file then we don't need to define  @PropertySource
//@PropertySource("classpath:service-one-test.properties")


//@ConfigurationProperties works best with hierarchical properties that
// all have the same prefix. So we add a prefix of mail.
@ConfigurationProperties(prefix = "mail")


//Add @Validated on the @ConfigurationProperties class,
//and javax.validation annotations on the fields we want to validate.
//there is an issue with using validations https://github.com/spring-projects/spring-boot/issues/8173
//@Validated


@Data
public class ConfigProperties {

    @Length(max = 4, min = 1)
    private String hostName;
    private int port;
    private String from;
    private List<String> defaultRecipients;
    @NotBlank
    private String notBlank;
    private Duration timeInNano;
}
