package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.repository.BookReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookReposirory bookReposirory;
    public List<Book> findAll(){
        return bookReposirory.findAll();
    }

    public Book save(Book book){
        return bookReposirory.save(book);
    }
}
