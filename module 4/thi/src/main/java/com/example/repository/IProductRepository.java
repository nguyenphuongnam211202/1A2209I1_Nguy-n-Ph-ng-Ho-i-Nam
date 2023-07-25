package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Page<Product> findAllByPrice(double price, Pageable pageable);

    Page<Product> findAllByCategory_CategoryNameContaining(String categoryName, Pageable pageable);

    Page<Product> findAllByNameContainingAndCategory_CategoryNameAndPrice(String name, String categoryName, double price, Pageable pageable);

    // Thêm phương thức tìm kiếm sản phẩm bằng categoryId
    Page<Product> findAllByCategory_Id(int categoryId, Pageable pageable);
}