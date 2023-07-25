package com.example.service;

import com.example.model.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowService {
    Page<Borrow> findAll(Pageable pageable);
    Page<Borrow> searchByStatus(String statusBorrow, Pageable pageable);

    Borrow findById(int id);
    boolean create(Borrow borrow);
    boolean update(Borrow borrow);
    boolean deleteById(int id);
}
