package com.example.app_blog.service;

import com.example.app_blog.model.Blog;

import java.util.List;

public interface IAppBlogService {
    List<Blog> findAll();

    void create(Blog blog);
    Blog findById(int id);
    void update(Blog blog);
    void deleteById(int id);
}
