package com.codegym.service;

import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> searchByName(String name, Pageable pageable);

    Page<Product> searchByQuantity(int quantity, Pageable pageable);

    public Page<Product> searchByNameAndQuantity(String name, Integer quantity, Pageable pageable);

    Product findById(int id);
    boolean create(Product product);
    boolean update(Product product);
    boolean deleteById(int id);
}
