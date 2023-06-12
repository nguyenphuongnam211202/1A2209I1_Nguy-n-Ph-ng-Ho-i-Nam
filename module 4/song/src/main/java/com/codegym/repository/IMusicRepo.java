package com.codegym.repository;

import com.codegym.entity.Music;

import java.util.List;

public interface IMusicRepo {
    List<Music> findAll();
    void create(Music music);
    void update(Music music);
    Music findById(int id);
    void delete(int id);
}
