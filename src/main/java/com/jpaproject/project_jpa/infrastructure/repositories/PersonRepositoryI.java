package com.jpaproject.project_jpa.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpaproject.project_jpa.domain.entities.Person;

public interface PersonRepositoryI extends CrudRepository<Person, Long>{

}
