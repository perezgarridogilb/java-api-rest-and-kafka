package com.andres.springboot.app.crudjpa.springboot_crud.services;

import java.util.List;

import com.andres.springboot.app.crudjpa.springboot_crud.models.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);

}
