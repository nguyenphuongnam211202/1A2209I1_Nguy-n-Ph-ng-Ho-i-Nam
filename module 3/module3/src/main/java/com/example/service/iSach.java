package com.example.service;

import com.example.model.Sach;

import java.util.List;

public interface iSach {
    Sach findById(String maSach);
    List<Sach> findAll();
}
