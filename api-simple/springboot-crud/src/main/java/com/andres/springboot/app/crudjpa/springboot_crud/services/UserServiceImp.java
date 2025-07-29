package com.andres.springboot.app.crudjpa.springboot_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.andres.springboot.app.crudjpa.springboot_crud.models.Role;
import com.andres.springboot.app.crudjpa.springboot_crud.models.User;
import com.andres.springboot.app.crudjpa.springboot_crud.repositories.RoleRepository;
import com.andres.springboot.app.crudjpa.springboot_crud.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Role> optionalRoleUser= roleRepository.findByName( "ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()) {
                Optional<Role> optionalRoleAdmin = roleRepository.findByName( "ROLE_ADMIN");
                optionalRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
    String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

}
