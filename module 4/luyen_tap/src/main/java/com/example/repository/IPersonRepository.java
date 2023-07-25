package com.example.repository;

import com.example.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
    Page<Person> findAllByNamePersonContaining(String namePerson, Pageable pageable);
}
