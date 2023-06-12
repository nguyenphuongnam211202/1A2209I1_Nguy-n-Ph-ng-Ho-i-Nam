package com.codegym.repository;

import com.codegym.entity.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> findAll();
    List<Comment> findAllToday(String date);
    Comment findById(int id);
    void addComment(Comment comment);
    void addLike(Comment comment);
}
