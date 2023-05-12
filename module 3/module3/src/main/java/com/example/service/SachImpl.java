package com.example.service;

import com.example.model.HocSinh;
import com.example.model.Sach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachImpl implements iSach {
    @Override
    public Sach findById(String maSach) {
        Sach sach = null;
        String sql = "select * from sach where ma_sach = ?;";
        Connection connection = new Connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, maSach);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maS = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                sach = new Sach(maS,tenSach,tacGia,moTa,soLuong);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sach;
    }

    @Override
    public List<Sach> findAll() {
        List<Sach> sachList = new ArrayList<>();
        String sql = "select * from sach";
        Connection connection = new Connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maS = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                sachList.add(new Sach(maS,tenSach,tacGia,moTa,soLuong));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sachList;
    }
    }

