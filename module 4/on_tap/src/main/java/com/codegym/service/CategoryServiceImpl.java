package com.codegym.service;

import com.codegym.entity.Category;
import com.codegym.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public boolean create(Category t) {
        iCategoryRepository.save(t);
        return true;
    }

    @Override
    public boolean update(Category t) {
        if(iCategoryRepository.existsById(t.getCategoryId())){
            iCategoryRepository.save(t);
            return true;
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        iCategoryRepository.deleteById(id);
        return true;
    }


}
