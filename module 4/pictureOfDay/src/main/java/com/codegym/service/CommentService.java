package com.codegym.service;

import com.codegym.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    List<Comment> findAllToday(String date);
    Comment findById(int id);
    void addComment(Comment comment);
    void addLike(Comment comment);
}
