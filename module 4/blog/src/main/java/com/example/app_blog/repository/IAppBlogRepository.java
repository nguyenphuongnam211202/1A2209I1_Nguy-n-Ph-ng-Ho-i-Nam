package com.example.app_blog.repository;

import com.example.app_blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface IAppBlogRepository extends CrudRepository<Blog,Integer> {

}
