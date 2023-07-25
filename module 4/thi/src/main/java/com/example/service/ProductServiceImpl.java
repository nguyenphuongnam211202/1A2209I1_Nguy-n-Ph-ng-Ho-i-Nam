package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Product product) {
        iProductRepository.save(product);
        System.out.println("OK");
        return true;
    }

    @Override
    public boolean update(Product product) {
        if (iProductRepository.existsById(product.getIdProduct())) {
            iProductRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        iProductRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Product> searchByPrice(double price, Pageable pageable) {
        return iProductRepository.findAllByPrice(price, pageable);
    }

    @Override
    public Page<Product> searchByCategory(String name, Pageable pageable) {
        return iProductRepository.findAllByCategory_CategoryNameContaining(name, pageable);
    }

    @Override
    public Page<Product> searchByNameAndPriceAndCategory(String name, String category, double price, Pageable pageable) {
        if (StringUtils.isEmpty(name) && price == 0 && StringUtils.isEmpty(category)) {
            return iProductRepository.findAll(pageable); // Trả về tất cả sản phẩm nếu không có điều kiện tìm kiếm
        } else if (StringUtils.isEmpty(name)) {
            return iProductRepository.findAllByPrice(price, pageable); // Tìm kiếm theo trường quantity nếu name trống
        } else if (price == 0) {
            return iProductRepository.findAllByNameContaining(name, pageable); // Tìm kiếm theo trường name nếu quantity không có giá trị
        } else if (StringUtils.isEmpty(name) &&price == 0) {
            return iProductRepository.findAllByCategory_CategoryNameContaining(category,pageable); // Tìm kiếm theo trường name nếu quantity không có giá trị
        } else {
            return iProductRepository.findAllByNameContainingAndCategory_CategoryNameAndPrice(name,category,price,pageable); // Tìm kiếm theo cả name và quantity nếu cả hai có giá trị
        }
    }
}
