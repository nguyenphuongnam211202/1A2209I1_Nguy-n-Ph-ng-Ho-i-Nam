package com.codegym.repository;

import com.codegym.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
    Optional<Borrow> findFirstByCode(String code);
}
