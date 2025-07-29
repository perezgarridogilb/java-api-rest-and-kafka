package com.andres.springboot.app.crudjpa.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.app.crudjpa.springboot_crud.models.Role;
import java.util.List;




public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
