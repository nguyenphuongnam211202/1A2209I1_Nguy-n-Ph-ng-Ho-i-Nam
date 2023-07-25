package com.codegym.practice.service.impl;

import com.codegym.practice.entity.Book;
import com.codegym.practice.entity.Code;
import com.codegym.practice.repository.IBookRepository;
import com.codegym.practice.repository.ICodeRepository;
import com.codegym.practice.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Autowired
    private ICodeRepository iCodeRepository;

    @Override
    public List<Book> findAllBook() {
        return iBookRepository.findAll();
    }

    @Override
    public boolean borrow(Book book, int usedCode) {
        if(book.getQuantity() == 0){
            return false;
        }

        List<Code> codeList = iCodeRepository.findAllCodeByBookId(book.getBookId());
        for (Code c : codeList) {
            if (c.getCode().equals(usedCode)) {
                c.setStatus("borrowed");
                book.setQuantity(book.getQuantity() - 1);
                iCodeRepository.save(c);
                iBookRepository.save(book);
                return true;
            }
        }

        return false;
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
        for (int i = 0; i < book.getQuantity(); i++) {
            int n = 10000 + new Random().nextInt(90000);
            Code code = new Code(n, "not borrowed",book);
            iCodeRepository.save(code);
        }
    }

    @Override
    public boolean returnBook(Book book, int usedCode) {
        List<Code> codeList = iCodeRepository.findAllCodeByBookId(book.getBookId());
        for (Code c : codeList) {
            if (c.getCode().equals(usedCode)){
                c.setStatus("not borrowed");
                book.setQuantity(book.getQuantity()+1);
                iCodeRepository.save(c);
                iBookRepository.save(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }
}
