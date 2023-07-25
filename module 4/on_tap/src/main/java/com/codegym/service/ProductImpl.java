package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductImpl implements ProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchByName( String name,Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Product> searchByQuantity(int quantity, Pageable pageable) {
        return iProductRepository.findAllByQuantity(quantity,pageable);
    }

    @Override
    public Page<Product> searchByNameAndQuantity(String name, Integer quantity, Pageable pageable) {
        if (StringUtils.isEmpty(name) && quantity == null) {
            return iProductRepository.findAll(pageable); // Trả về tất cả sản phẩm nếu không có điều kiện tìm kiếm
        } else if (StringUtils.isEmpty(name)) {
            return iProductRepository.findAllByQuantity(quantity, pageable); // Tìm kiếm theo trường quantity nếu name trống
        } else if (quantity == null) {
            return iProductRepository.findAllByNameContaining(name, pageable); // Tìm kiếm theo trường name nếu quantity không có giá trị
        } else {
            return iProductRepository.findAllByNameContainingAndQuantity(name, quantity, pageable); // Tìm kiếm theo cả name và quantity nếu cả hai có giá trị
        }
    }




    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Product product) {
        iProductRepository.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if(iProductRepository.existsById(product.getId())){
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
}
