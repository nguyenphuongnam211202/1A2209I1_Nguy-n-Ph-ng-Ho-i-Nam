package com.example.controller;

import com.example.dao.BenhAnDAO;
import com.example.model.BenhAn;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "benhAn", value = {"/benhAn",""})
public class BenhAnServlet extends HttpServlet {

    private BenhAnDAO benhAnDAO;
    @Override
    public void init() throws ServletException {
        benhAnDAO = new BenhAnDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                listBenhAn(request, response);
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

            case "update":
                update(request,response);
                break;
            case "search":
                break;
            default:
                break;

        }
    }

    protected void listBenhAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhAn> listBenhAn = benhAnDAO.selectAll();
        request.setAttribute("listBenhAn", listBenhAn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("id");
        try {
            benhAnDAO.delete(maBenhAn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/benhAn");

    }


        protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        String maBenhNhan = request.getParameter("maBenhNhan");
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String lyDo = request.getParameter("lyDoNhapVien");
        BenhAn benhAn = new BenhAn(maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo);
        try {
            benhAnDAO.updateBenhAn(benhAn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            benhAnDAO.updateBenhNhan(benhAn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        response.sendRedirect("/benhAn");
    }

        protected void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("id");
        BenhAn benhAn = benhAnDAO.findById(maBenhAn);
        request.setAttribute("ba", benhAn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/edit.jsp");
        dispatcher.forward(request, response);
    }

    }