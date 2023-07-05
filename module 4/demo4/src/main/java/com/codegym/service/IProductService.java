package com.codegym.service;

import com.codegym.model.Products;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Products> findAll();
    Optional<Products> findById(int id);

}
