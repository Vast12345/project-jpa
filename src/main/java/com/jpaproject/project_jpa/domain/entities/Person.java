package com.jpaproject.project_jpa.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "lastname")
    private String lastName;
    private String email;

    @Column(name="programming_language")
    private String programminglanguage;

    public Person() {
    }
    public Person(String name, String lastName, String email, String programminglanguage) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.programminglanguage = programminglanguage;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getProgramminglanguage() {
        return programminglanguage;
    }
    public void setProgramminglanguage(String programminglanguage) {
        this.programminglanguage = programminglanguage;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + "\nname=" + name + "\nlastName=" + lastName + "\nemail=" + email + "\nprogramminglanguage="
                + programminglanguage + "]\n";
    }
}