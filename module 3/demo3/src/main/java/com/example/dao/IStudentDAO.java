package com.example.dao;

import com.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public List<Student> locTheoKhoa(String khoa);
    public List<Student> selectAll();
    public void insertStudent(Student student) throws SQLException;
    public void updateStudent(Student student) throws  SQLException;

    public void deleteStudent(int id) throws  SQLException;
    public Student getStudent(String userName, String password);

}
