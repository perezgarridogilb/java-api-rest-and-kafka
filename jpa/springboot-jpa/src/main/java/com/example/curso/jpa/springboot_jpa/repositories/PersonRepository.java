package com.example.curso.jpa.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.curso.jpa.springboot_jpa.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
