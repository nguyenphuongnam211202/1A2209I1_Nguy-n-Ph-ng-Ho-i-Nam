package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(120)")
    @NotBlank
    private String fullName;

    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    public User(){}
    public User(int id, String fullName, String phone, LocalDate birthdate) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
