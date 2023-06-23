package com.example.controller;

import com.example.dao.IStudentDAO;
import com.example.dao.StudentDAO;
import com.example.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
                break;
            case "edit":
                break;
            case "delete":
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
            case "create":
                break;
            case " update":
                break;
            case "dangnhap":
                showList(request,response);
                break;
            case "xem":
                locKhoa(request,response);
            default:
                break;

        }
    }

    protected void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/view/login.jsp");
    }

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