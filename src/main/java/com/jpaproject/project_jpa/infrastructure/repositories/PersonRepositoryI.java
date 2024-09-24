package com.jpaproject.project_jpa.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpaproject.project_jpa.domain.entities.Person;

public interface PersonRepositoryI extends CrudRepository<Person, Long>{
    List<Person> findByProgramminglanguage(String programminglanguage);
    @Query("select p from Person p where p.programminglanguage like %?1%")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);
}
