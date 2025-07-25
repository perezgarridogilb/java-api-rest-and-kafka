package com.andres.springboot.app.crudjpa.springboot_crud.validation;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidation implements ConstraintValidator<isRequired, String> {
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        // if (value != null && !value.isEmpty() && !value.isBlank()) {
            return StringUtils.hasText(value);
        // // }
        // return false;
    }
}
