package com.example.repository;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findAllByNameBookContaining(String nameBook, Pageable pageable);

    Page<Book>findAllByAuthorContaining(String author, Pageable pageable);
    Page<Book> findAllByNameBookContainingAndAuthorContaining(String nameBook, String author, Pageable pageable);
}
