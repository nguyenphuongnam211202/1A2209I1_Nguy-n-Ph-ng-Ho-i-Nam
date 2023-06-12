package com.example.app_blog.service;

import com.example.app_blog.model.Blog;
import com.example.app_blog.repository.IAppBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service
@Transactional
public class AppBlogServiceImpl implements IAppBlogService{

    @Autowired
    private IAppBlogRepository repository;


    @Override
    public List<Blog> findAll() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public void create(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
