package com.example.service.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class GoodNameValidator implements ConstraintValidator<HasGoodName, String> {

    private String validatorLocalValue;

    @Override
    public void initialize(HasGoodName constraintAnnotation) {
        validatorLocalValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equalsIgnoreCase("vahid");
    }

}