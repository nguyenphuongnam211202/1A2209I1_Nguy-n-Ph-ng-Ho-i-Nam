package com.example.controller;

import com.example.dao.IStudentDAO;
import com.example.dao.StudentDAO;
import com.example.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "student", value = {"/students",""})
public class StudentController extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
            default:
                showLogin(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "them moi":
                try {
                    create(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "luu lai":
                try {
                    update(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "dangnhap":
                showList(request,response);
                break;
            case "xem":
                locKhoa(request,response);
            case "xac nhan":
                try {
                    delete(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:
                list(request,response);
                break;

        }
    }

    protected void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/view/login.jsp");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String mssv = request.getParameter("mssv");
        String hoTen = request.getParameter("hoTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String khoa = request.getParameter("listKhoa");
        Student student = new Student(id,mssv,hoTen,gioiTinh,khoa);
        studentDAO.updateStudent(student);
        list(request,response);    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String mssv = request.getParameter("mssv");
        String hoTen = request.getParameter("hoTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String khoa = request.getParameter("listKhoa");
        Student student = new Student(mssv,hoTen,gioiTinh,khoa);
        studentDAO.insertStudent(student);
        list(request,response);

    }
    protected void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.findById(id);
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.findById(id);
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/delete.jsp");
        requestDispatcher.forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        list(request,response);

    }
    protected void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/view/create.jsp");
    }
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentDAO.selectAll();
        request.setAttribute("studentList",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
        requestDispatcher.forward(request,response);    }

    protected void locKhoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String khoa = request.getParameter("listKhoa");
        List<Student> studentList = studentDAO.locTheoKhoa(khoa);
        request.setAttribute("studentList",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
        requestDispatcher.forward(request,response);
    }
    protected void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("tenDangNhap");
        String password = request.getParameter("matKhau");
        Student student = studentDAO.getStudent(userName,password);
        if(student != null){
            List<Student> studentList = studentDAO.selectAll();
            request.setAttribute("studentList",studentList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
            requestDispatcher.forward(request,response);
        }else {
            String message = "Tài khoản hoặc mật khẩu không chính xác";
            request.setAttribute("message",message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/login.jsp");
            requestDispatcher.forward(request,response);
        }

    }


}