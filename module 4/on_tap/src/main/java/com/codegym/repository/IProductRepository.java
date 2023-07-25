package com.codegym.repository;

import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameContaining(String name,Pageable pageable);

    Page<Product> findAllByQuantity(int quantity,Pageable pageable);

    Page<Product> findAllByNameContainingAndQuantity(String name, Integer quantity, Pageable pageable);




}
