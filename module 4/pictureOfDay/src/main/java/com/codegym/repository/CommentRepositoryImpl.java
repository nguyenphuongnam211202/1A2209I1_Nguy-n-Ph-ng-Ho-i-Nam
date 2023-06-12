package com.codegym.repository;

import com.codegym.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Comment> findAll() {
        return entityManager.createQuery("select c from Comment c ").getResultList();
    }

    @Override
    public List<Comment> findAllToday(String date) {
        return entityManager.createQuery("select c from Comment c where c.date=?1").setParameter(1,date).getResultList();
    }

    @Override
    public Comment findById(int id) {
        return entityManager.find(Comment.class,id);
    }

    @Override
    public void addComment(Comment comment) {
        comment.setDate();
        entityManager.persist(comment);
    }

    @Override
    public void addLike(Comment comment) {
        int newike = comment.getLikes() + 1;
        comment.setLikes(newike);
        entityManager.merge(comment);
    }
}
