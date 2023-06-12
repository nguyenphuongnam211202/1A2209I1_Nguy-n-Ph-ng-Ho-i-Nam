package com.codegym.service;

import com.codegym.entity.Music;
import com.codegym.repository.IMusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService{

    @Autowired
    private IMusicRepo repo;

    @Override
    public List<Music> findAll() {
        return repo.findAll();
    }

    @Override
    public void create(Music music) {
        repo.create(music);
    }

    @Override
    public void update(Music music) {
        repo.update(music);
    }

    @Override
    public Music findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }
}
