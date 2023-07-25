package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {

    boolean create(Book book);
    Book findById(int id);
    Page<Book> findAllPage(Pageable pageable);
    List<Book> findAll();
    Page<Book> searchByNameAndAuthor(String nameBook, String author, Pageable pageable);

}
