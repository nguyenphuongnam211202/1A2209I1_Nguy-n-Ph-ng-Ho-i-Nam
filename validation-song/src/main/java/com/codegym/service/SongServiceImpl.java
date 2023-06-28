package com.codegym.service;

import com.codegym.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService{


    @Override
    public List<Song> findAll() {
        return null;
    }

    @Override
    public boolean create(Song song) {
        return false;
    }

    @Override
    public boolean update(Song song) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public Song findById(int id) {
        return null;
    }
}
