package com.codegym.pratice.service;

import com.codegym.pratice.model.BenhAn;
import com.codegym.pratice.model.BenhNhan;

import java.util.List;

public interface IBenhNhanService {
    List<BenhNhan> findAllBenhNhan();
    void save(BenhNhan benhNhan);
    void remove(String id);
    BenhNhan findById(String id);
}
