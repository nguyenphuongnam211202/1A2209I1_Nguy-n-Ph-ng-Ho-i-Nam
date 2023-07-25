package com.example.service;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService{
   @Autowired
   private IBookRepository iBookRepository;
    @Override
    public boolean create(Book book) {
        iBookRepository.save(book);
        return true ;
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Book> findAllPage(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }


    @Override
    public Page<Book> searchByNameAndAuthor(String nameBook, String author, Pageable pageable) {
//        if (StringUtils.hasText(nameBook) && StringUtils.hasText(author)) {
//            books = bookRepository.findAllByNameBookContainingAndAuthorContaining(nameBook, author, pageable);
//        } else if (StringUtils.hasText(nameBook)) {
//            books = bookRepository.findAllByNameBookContaining(nameBook, pageable);
//        } else if (StringUtils.hasText(author)) {
//            books = bookRepository.findAllByAuthorContaining(author, pageable);
//        } else {
//            // Trường hợp không có thông tin tìm kiếm được cung cấp
//            books = bookRepository.findAll(pageable);
//        }
        return null;
    }



}
