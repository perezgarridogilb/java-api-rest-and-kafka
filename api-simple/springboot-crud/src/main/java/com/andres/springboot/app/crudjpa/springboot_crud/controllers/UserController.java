package com.andres.springboot.app.crudjpa.springboot_crud.controllers;

import java.security.Provider.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.app.crudjpa.springboot_crud.models.Role;
import com.andres.springboot.app.crudjpa.springboot_crud.models.User;
import com.andres.springboot.app.crudjpa.springboot_crud.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping
    public List<User> list() {
        return service.findAll();
    }
    /**
     * Desafortunadamente siempre BindingResult deve ir a la derecha del objeto que se va a validar: 186
     * @param product
     * @param result
     * @return
     */
    @PostMapping
    public  ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

        @PostMapping("/register")
    public  ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        user.setAdmin(false);
        return create(user, result);
    }
    
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
            });
        return ResponseEntity.badRequest().body(errors);
    }

}
