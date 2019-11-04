package com.example.service.domain.validation;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = GoodNameValidator.class)
@Documented
public @interface HasGoodName {

    String message() default "Name is not allowed. it is not a good name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

     String value() default "";
}