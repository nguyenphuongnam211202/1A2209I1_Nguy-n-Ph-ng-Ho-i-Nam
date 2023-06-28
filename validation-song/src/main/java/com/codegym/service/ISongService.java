package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    boolean create(Song song);
    boolean update(Song song);
    boolean deleteById(int id);
    Song findById(int id);


}
