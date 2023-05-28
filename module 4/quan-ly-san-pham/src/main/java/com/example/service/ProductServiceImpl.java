package com.example.service;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements iProductService{

    private static final Map<Integer,Product> products;
    static{
        products = new HashMap<>();
        products.put(1,new Product(1,"ao",100000,"mau vang","Taobao"));
        products.put(2,new Product(2,"quan",150000,"mau xanh","1998"));
        products.put(3,new Product(3,"vay",80000,"mau hong","1998"));
        products.put(4,new Product(4,"yem",75000,"mau do","Taobao"));
        products.put(5,new Product(5,"giay",120000,"mau tim","1998"));
        products.put(6,new Product(6,"non",50000,"mau xam","Taobao"));
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
