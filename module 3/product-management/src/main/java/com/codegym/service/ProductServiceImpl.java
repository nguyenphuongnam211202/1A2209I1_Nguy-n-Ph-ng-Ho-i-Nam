package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> products;
    static{
        products = new HashMap<>();
        products.put(1, new Product(1,"áo",110000,"màu vàng, size M","TaoBao"));
        products.put(2, new Product(2,"áo croptop",90000,"màu trắng, size S","1998"));
        products.put(3, new Product(3,"quần",150000,"jean, size M","ABC"));
        products.put(4, new Product(4,"váy",150000,"màu hồng, size S","ABC"));
        products.put(5, new Product(5,"yếm",100000,"màu be, size L","TaoBao"));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
