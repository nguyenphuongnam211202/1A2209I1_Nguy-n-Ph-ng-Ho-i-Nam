package com.example.dao;

import com.example.model.BenhAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnDAO implements IBenhAnDAO {

    public static final String SELECT_ALL_PRODUCT = "call thi.select_all_product();";
    public static final String UPDATE_BENH_AN = "update benh_an set ngay_nhap_vien = ?, ngay_ra_vien = ?, ly_do =? where ma_benh_an = ?";
    public static final String UPDATE_BENH_NHAN = "update benh_nhan set ten_benh_nhan =? where ma_benh_nhan = ?";
    public static final String DELETE_BENH_AN = "delete from benh_an where ma_benh_an = ?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/thi";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    public BenhAnDAO() {
    }


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public BenhAn findById(String maBenhAn) {
        BenhAn benhAn = null;
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall("call thi.select_benh_an(?);");
        ) {
            callableStatement.setString(1, maBenhAn);
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String maBenhNhan = rs.getString("ma_benh_nhan");
                String tenBenhNhan = rs.getString("ten_benh_nhan");
                String ngayNhapVien = rs.getString("ngay_nhap_vien");
                String ngayRaVien = rs.getString("ngay_ra_vien");
                String lyDo = rs.getString("ly_do");
                benhAn = new BenhAn(maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAn;
    }

    @Override
    public List<BenhAn> selectAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_PRODUCT)) {
            System.out.println(SELECT_ALL_PRODUCT);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String maBenhAn = rs.getString("ma_benh_an");
                String maBenhNhan = rs.getString("ma_benh_nhan");
                String tenBenhNhan = rs.getString("ten_benh_nhan");
                String ngayNhapVien = rs.getString("ngay_nhap_vien");
                String ngayRaVien = rs.getString("ngay_ra_vien");
                String lyDo = rs.getString("ly_do");
                benhAnList.add(new BenhAn(maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAnList ;
    }


    @Override
    public void updateBenhAn(BenhAn benhAn) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENH_AN);
        preparedStatement.setString(1,benhAn.getNgayNhapVien());
        preparedStatement.setString(2,benhAn.getNgayNhapVien());
        preparedStatement.setString(3,benhAn.getLyDo());
        preparedStatement.setString(4,benhAn.getMaBenhAn());
        System.out.println(UPDATE_BENH_AN);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateBenhNhan(BenhAn benhAn) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENH_NHAN);
        preparedStatement.setString(1,benhAn.getTenBenhNhan());
        preparedStatement.setString(2,benhAn.getMaBenhNhan());
        System.out.println(UPDATE_BENH_AN);
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(String maBenhAn) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BENH_AN);
        preparedStatement.setString(1,maBenhAn);
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public int getIdByName(String name) {
        return 0;
    }


}
