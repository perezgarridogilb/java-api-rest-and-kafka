package com.example.curso.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;

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
		/* list(); */
		findOne();
	}

	public void findOne() {
		// Person person = null;
		// Optional<Person> optionalPerson = personRepository.findOneName("Pepe");
		// if (!optionalPerson.isEmpty()) {
		// 	person = optionalPerson.get();
		// }
		// System.out.println(person);
		// personRepository.findById(1L).ifPresent(person1 -> System.out.println(person1));
		// personRepository.findById(1L).ifPresent(System.out::println);
		// personRepository.findOneName("Pepe").ifPresent(System.out::println);
		personRepository.findByNameContaining("se").ifPresent(System.out::println);
	}

	public void list() {
		List<Person> persons = personRepository.findByProgrammingLanguagueAndName("Java", "Andres");

		persons.stream().forEach(person -> {
			System.out.println(person);
		});

		List<Object[]> personsValues = personRepository.obtenerPersonData("Python", "Pepe");
				personsValues.stream().forEach(person -> {
					System.out.println(person[0] + " es experto en " + person[1]);
				});
	}

}
