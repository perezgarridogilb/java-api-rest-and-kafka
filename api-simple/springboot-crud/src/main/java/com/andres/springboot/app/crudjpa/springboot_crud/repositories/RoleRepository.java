package com.andres.springboot.app.crudjpa.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.app.crudjpa.springboot_crud.models.Role;



public interface RoleRepository extends CrudRepository<Role, Long> {

}
