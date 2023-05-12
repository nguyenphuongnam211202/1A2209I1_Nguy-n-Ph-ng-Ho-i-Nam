package com.example.service;

import com.example.model.HocSinh;
import com.example.model.Sach;

import java.util.List;

public interface iHocSinh {
    HocSinh findById(String maHocSinh);
    List<HocSinh> findAll();
}
