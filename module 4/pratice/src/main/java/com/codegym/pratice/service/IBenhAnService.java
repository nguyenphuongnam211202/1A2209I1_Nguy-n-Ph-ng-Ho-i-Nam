package com.codegym.pratice.service;

import com.codegym.pratice.model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> findAllBenhAn();
    void save(BenhAn benhAn);
    void remove(String id);
    BenhAn findById(String id);
}
