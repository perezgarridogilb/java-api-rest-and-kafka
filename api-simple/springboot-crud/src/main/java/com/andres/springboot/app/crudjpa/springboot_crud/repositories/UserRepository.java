package com.andres.springboot.app.crudjpa.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.app.crudjpa.springboot_crud.models.User;

public interface UserRepository extends CrudRepository<User, Long>  {

}
