package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReposirory extends JpaRepository<Book,Integer> {
}
