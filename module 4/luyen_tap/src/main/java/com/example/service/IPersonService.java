package com.example.service;

import com.example.model.Book;
import com.example.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonService {
    boolean create(Person person);
    Person findById(int id);
    Page<Person> findAllPage(Pageable pageable);
    List<Person> findAll( );
    Page<Person> searchByName(String name, Pageable pageable);
}
