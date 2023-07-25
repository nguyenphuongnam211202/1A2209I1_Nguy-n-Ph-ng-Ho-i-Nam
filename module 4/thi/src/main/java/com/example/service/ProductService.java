package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> searchByName(String name, Pageable pageable);
    Page<Product> searchByPrice(double price, Pageable pageable);
    Page<Product> searchByCategory(String categoryName, Pageable pageable);
    Page<Product> searchByNameAndPriceAndCategory(String name, String categoryName, double price, Pageable pageable);
    Page<Product> searchByCategoryId(int categoryId, Pageable pageable); // Thêm phương thức tìm kiếm sản phẩm bằng categoryId

    Product findById(int id);
    boolean create(Product product);
    boolean update(Product product);
    boolean deleteById(int id);
}