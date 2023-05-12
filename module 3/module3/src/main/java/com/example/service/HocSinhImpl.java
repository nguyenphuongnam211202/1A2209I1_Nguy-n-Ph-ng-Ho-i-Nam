package com.example.service;

import com.example.model.HocSinh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.service.Connection;


public class HocSinhImpl implements iHocSinh {
    @Override
    public HocSinh findById(String maHocSinh) {
        HocSinh hocSinh = null;
        String sql = "select * from hoc_sinh where ma_hoc_sinh = ?;";
        Connection connection =  new Connection() ;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, maHocSinh);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maHs = resultSet.getString("ma_hoc_sinh");
                String hoTen = resultSet.getString("ho_ten");
                String lop = resultSet.getString("lop");
                hocSinh = new HocSinh(maHs, hoTen, lop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return hocSinh;
    }

    @Override
    public List<HocSinh> findAll() {
        List<HocSinh> hocSinhList = new ArrayList<>();
        String sql = "select * from hoc_sinh";
        Connection connection = new Connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maHs = resultSet.getString("ma_hoc_sinh");
                String hoTen = resultSet.getString("ho_ten");
                String lop = resultSet.getString("lop");
                hocSinhList.add(new HocSinh(maHs, hoTen, lop));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return hocSinhList;
    }
}

