package com.example.service;

import com.example.model.TheMuonSach;

import java.util.List;

public interface iTheMuonSach {
    void add(TheMuonSach theMuonSach);
    void update(int soLuong);
    List<TheMuonSach> findAll();
    List<TheMuonSach> findByBook();
    List<TheMuonSach> findByStudent();
}
