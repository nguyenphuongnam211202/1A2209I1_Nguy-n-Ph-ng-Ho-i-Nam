package com.example.controller;

import com.example.model.TheMuonSach;
import com.example.service.*;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "book", value = {"/books",""})
public class BookServlet extends HttpServlet {
    iTheMuonSach theMuonSach = new TheMuonSachImpl();

    iSach sach = new SachImpl();

    iHocSinh hocSinh = new HocSinhImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "search":
                break;
            case "edit":
                break;
            default:

                break;
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "delete":
                break;
            case "edit":
                break;
            default:
                showList(request, response);
                break;
        }
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<TheMuonSach> theMuonSachList = theMuonSach.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
        request.setAttribute("theMuonSachList", theMuonSachList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}