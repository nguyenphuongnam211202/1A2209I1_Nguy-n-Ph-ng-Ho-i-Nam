package com.codegym.service;

import com.codegym.entity.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void create (Music music);
    void update(Music music);
    Music findById(int id);
    void delete (int id);
}
