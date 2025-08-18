package com.example.curso.jpa.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.curso.jpa.springboot_jpa.models.Person;
import com.example.curso.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguague("Java", "Andres");
List<Person> persons = personRepository.findByProgrammingLanguagueAndName("Java", "Andres");

		persons.stream().forEach(person -> {
			System.out.println(person);
		});
	}

}
