package com.codegym.service;

import com.codegym.exeception.BookBorrowException;
import com.codegym.model.Book;
import com.codegym.model.Borrow;
import com.codegym.model.User;
import com.codegym.repository.BookReposirory;
import com.codegym.repository.BorrowRepository;
import com.codegym.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookReposirory bookReposirory;

    public BorrowService(BorrowRepository borrowRepository, UserRepository userRepository, BookReposirory bookReposirory) {
        this.borrowRepository = borrowRepository;
        this.userRepository = userRepository;
        this.bookReposirory = bookReposirory;
    }

    @Transactional(rollbackOn = Exception.class)
    public boolean borrow(Book book, User user) {
        if (book.getQuantity() == 0) {
            throw new BookBorrowException("so luong sach khong duoc duoi 0");
        }

        try {
            User newUser = userRepository.save(user);
            book.setQuantity(book.getQuantity() - 1);
            bookReposirory.save(book);
            Borrow borrow = new Borrow();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

}
