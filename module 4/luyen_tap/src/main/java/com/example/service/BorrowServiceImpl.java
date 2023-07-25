package com.example.service;

import com.example.model.Borrow;
import com.example.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements IBorrowService {
    @Autowired
    private IBorrowRepository iBorrowRepository;
    @Override
    public Page<Borrow> findAll(Pageable pageable) {
        return iBorrowRepository.findAll(pageable);
    }

    @Override
    public Page<Borrow> searchByStatus(String statusBorrow, Pageable pageable) {
        return iBorrowRepository.findAllByStatusBorrowContaining(statusBorrow,pageable);
    }

    @Override
    public Borrow findById(int id) {
        return iBorrowRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Borrow borrow) {
        iBorrowRepository.save(borrow);
        return true;
    }

    @Override
    public boolean update(Borrow borrow) {
        if(iBorrowRepository.existsById(borrow.getIdBorrow())){
            iBorrowRepository.save(borrow);
            return true;
        }
        return false;    }

    @Override
    public boolean deleteById(int id) {
        iBorrowRepository.deleteById(id);
        return true;
    }
}
