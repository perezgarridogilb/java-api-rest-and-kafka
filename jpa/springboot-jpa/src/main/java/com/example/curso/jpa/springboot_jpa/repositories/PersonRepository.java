package com.example.curso.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.curso.jpa.springboot_jpa.models.Person;
import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Long> {
   
    List<Person> findByProgrammingLanguague(String programmingLanguague);


    @Query("select p from Person p where p.programmingLanguague=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguague(String programmingLanguague, String name);
    
List<Person> findByProgrammingLanguagueAndName(String programmingLanguague, String name);

}
