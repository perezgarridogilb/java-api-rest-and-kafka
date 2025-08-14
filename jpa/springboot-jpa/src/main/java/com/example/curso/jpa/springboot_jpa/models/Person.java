package com.example.curso.jpa.springboot_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastname;
    private String name;


        @Column(name = "programming_language")
    private String programmingLanguague;
// declaramos este que usa jpa/hibernate   
    public Person() {
    }
// si usamos este
    public Person(Long id, String lastname, String name, String programmingLanguague) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.programmingLanguague = programmingLanguague;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProgrammingLanguague() {
        return programmingLanguague;
    }
    public void setProgrammingLanguague(String programmingLanguague) {
        this.programmingLanguague = programmingLanguague;
    }
    @Override
    public String toString() {
        return "[id=" + id + ", lastname=" + lastname + ", name=" + name + ", programmingLanguague="
                + programmingLanguague + "]";
    }

    
}
