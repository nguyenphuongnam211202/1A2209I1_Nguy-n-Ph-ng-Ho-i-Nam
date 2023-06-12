package com.codegym.repository;

import com.codegym.entity.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepo implements IMusicRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Music> findAll() {
        return entityManager.createQuery("select s from Music s").getResultList();
    }

    @Override
    public void create(Music music) {
        entityManager.persist(music);
    }

    @Override
    public void update(Music music) {
        entityManager.persist(music);
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class,id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
