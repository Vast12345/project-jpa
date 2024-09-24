package com.jpaproject.project_jpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.jpaproject.project_jpa.domain.entities.Person;
import com.jpaproject.project_jpa.infrastructure.repositories.PersonRepositoryI;

@SpringBootApplication
public class ProjectJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepositoryI personRepositoryI;
	public static void main(String[] args) {
		SpringApplication.run(ProjectJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el opcion");
		int option = scanner.nextInt();

		switch (option) {
			case 1:
				create();
				break;
			case 2:
				findByLanguage();
				break;
			default:
				break;
		}
		scanner.close();
	}

	@Transactional
	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre");
		String name = scanner.next();
		System.out.println("Ingrese el apellido");
		String lastname = scanner.next();
		System.out.println("Ingrese email");
		String email = scanner.next();
		System.out.println("Ingrese lenguaje de programacion");
		String programminglanguage = scanner.next();
		scanner.close();

		Person person = new Person(name, lastname, email,  programminglanguage);

		Person personNew = personRepositoryI.save(person);
		System.out.println(personNew);
		personRepositoryI.findById(personNew.getId()).ifPresent(System.out::println);
	}

	@Transactional
	public void findByLanguage() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el Lenguaje de Programacion");
		String programminglanguage = scanner.next();
		scanner.close();

		List<Person> people = personRepositoryI.findByProgramminglanguage(programminglanguage);

		System.out.println("Processing");

		people.stream().forEach(person -> System.out.println(person.toString()));

	}
}
