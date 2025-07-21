package com.andres.springboot.app.crudjpa.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.andres.springboot.app.crudjpa.springboot_crud.models.Product;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "es requerido.2");
        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", null, "es requerido, por favor.2");
        }
        if (product.getPrice() == null) {
            errors.rejectValue("description", null, "no puede ser nulo, ok!.2");
        } else if (product.getPrice() < 500) {
            errors.rejectValue("price", null, "no puede ser esa cantidad menor.2");
        }
    }

}
