package com.andres.springboot.app.crudjpa.springboot_crud.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByUsernameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByUsername {
    String message() default "ya existe en la base de datos, escoja otro username.[2]";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
