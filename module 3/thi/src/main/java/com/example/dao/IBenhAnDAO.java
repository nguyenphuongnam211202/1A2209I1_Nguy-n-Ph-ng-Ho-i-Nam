package com.example.dao;

import com.example.model.BenhAn;

import java.sql.SQLException;
import java.util.List;

public interface IBenhAnDAO {

    public BenhAn findById(String maBenhAn);
    public List<BenhAn> selectAll();
    public void updateBenhAn(BenhAn benhAn) throws SQLException;

    public void delete(String maBenhAn) throws  SQLException;

    public int getIdByName(String name);

    public void updateBenhNhan(BenhAn benhAn) throws SQLException;
}
