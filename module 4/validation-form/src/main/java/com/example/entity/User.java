package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "First name khong duoc de trong")
    @Size(min = 5, max = 45, message = "First name có độ dài tối thiểu 5, tối đa 45 ký tự" )
    @Column(columnDefinition = "nvarchar(45)")
    private String firstName;

    @NotBlank(message = "Last name khong duoc de trong")
    @Size(min = 5, max = 45, message = "Last name có độ dài tối thiểu 5, tối đa 45 ký tự" )
    @Column(columnDefinition = "nvarchar(45)")
    private String lastName;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Số điện thoại không đúng cú pháp")
    @Column
    private String phoneNumber;

    @Email
    @Column
    private String email;

    public User(){}

    public User(int id, String firstName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
