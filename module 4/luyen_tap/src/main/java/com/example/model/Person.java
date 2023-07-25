package com.example.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private int idPerson;

    @NotBlank(message = "khong duoc de trong")
    private String namePerson;

    public Person() {
    }

    public Person(int idPerson, String namePerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }
}
