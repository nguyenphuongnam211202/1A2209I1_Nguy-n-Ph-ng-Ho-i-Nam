package com.codegym.service;

import com.codegym.entity.Comment;
import com.codegym.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findAllToday(String date) {
        return commentRepository.findAllToday(date);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    @Override
    public void addLike(Comment comment) {
        commentRepository.addLike(comment);
    }
}
