package com.example.dao;

import com.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    public static final String CHECK_ACCOUNT = "select * from student where user_name = ? and pass_word = ?";
    public static final String SELECT_ALL_STUDENT = "select id, mssv, ho_ten, gioi_tinh, khoa  from student ";
    public static final String SELECT_KHOA = "select id, mssv, ho_ten, gioi_tinh, khoa  from student where khoa = ?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo3";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    public StudentDAO() {
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
    public List<Student> locTheoKhoa(String khoa) {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KHOA)) {
            preparedStatement.setString(1,khoa);
            System.out.println(SELECT_KHOA);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String mssv = rs.getString("mssv");
                String hoTen = rs.getString("ho_ten");
                String gioiTinh = rs.getString("gioi_tinh");
                studentList.add(new Student(id, mssv, hoTen, gioiTinh, khoa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)) {
            System.out.println(SELECT_ALL_STUDENT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String mssv = rs.getString("mssv");
                String hoTen = rs.getString("ho_ten");
                String gioiTinh = rs.getString("gioi_tinh");
                String khoa = rs.getString("khoa");
                studentList.add(new Student(id, mssv, hoTen, gioiTinh, khoa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public void insertStudent(Student student) throws SQLException {

    }

    @Override
    public void updateStudent(Student student) throws SQLException {

    }

    @Override
    public void deleteStudent(int id) throws SQLException {

    }

    @Override
    public Student getStudent(String userName, String password) {
        Student student = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ACCOUNT)) {
            System.out.println(CHECK_ACCOUNT);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String mssv = rs.getString("mssv");
                String hoTen = rs.getString("ho_ten");
                String gioiTinh = rs.getString("gioi_tinh");
                String khoa = rs.getString("khoa");
                student = new Student(id, mssv, hoTen, gioiTinh, khoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
