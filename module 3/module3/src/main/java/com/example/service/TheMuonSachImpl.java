package com.example.service;

import com.example.model.HocSinh;
import com.example.model.Sach;
import com.example.model.TheMuonSach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachImpl implements iTheMuonSach{

    public static final String ALL_THE_MUON_SACH = "select * from the_muon_sach;";

    @Override
    public void add(TheMuonSach theMuonSach) {

    }

    @Override
    public void update(int soLuong) {

    }

    @Override
    public List<TheMuonSach> findAll() {
        Connection connection = new Connection();
        iSach isach = new SachImpl();
        iHocSinh ihocSinh = new HocSinhImpl();
        List<TheMuonSach> theMuonSachList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(ALL_THE_MUON_SACH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMuonSach = resultSet.getString(1);
                String maSach = resultSet.getString(2);
                Sach sach = isach.findById(maSach);
                String maHocSinh = resultSet.getString(3);
                HocSinh hocSinh = ihocSinh.findById(maHocSinh);
                String trangThai = resultSet.getString(4);
                String ngayMuon = resultSet.getString(5);
                String ngayTra = resultSet.getString(6);
                theMuonSachList.add(new TheMuonSach(maMuonSach,hocSinh,sach,trangThai,ngayMuon,ngayTra));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return theMuonSachList;
    }

    @Override
    public List<TheMuonSach> findByBook() {
        return null;
    }

    @Override
    public List<TheMuonSach> findByStudent() {
        return null;
    }
}
