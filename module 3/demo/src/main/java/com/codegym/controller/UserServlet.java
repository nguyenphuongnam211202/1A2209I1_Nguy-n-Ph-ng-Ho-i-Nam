package com.codegym.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.codegym.dao.UserDAO;
import com.codegym.model.User;

@WebServlet(name = "UserServlet", urlPatterns = {"/users",""})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                listUser(request, response);
                break;
            case "sortByName":
                sortByName(request, response);
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
                createUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "findByCountry":
                findByCountry(request, response);
                break;
            default:
                break;

        }
    }


    protected void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward(request, response);
    }


    protected void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users;
        String q = request.getParameter("searchValue");
//        if(q != ""){
//
//            users = userDAO.selectAllUsers().stream().filter(e -> e.getCountry().equals(q)).sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
//        }
//        else {
//            users =userDAO.sortByName();
//        }


        request.setAttribute("listUser", userDAO.sortByName(q));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void findByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("findCountry");
        List<User> listUser = userDAO.selectUserByCountry(country);
        request.setAttribute("listUser", listUser);
        request.setAttribute("search", country);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message", "update successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/edit.jsp");
        dispatcher.forward(request, response);
    }

    protected void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        try {
            userDAO.insertUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        request.setAttribute("message", "create new user successful");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/create.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/users?action=&isCreate=2");
    }


    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/user/create.jsp");
    }


    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/edit.jsp");
        dispatcher.forward(request, response);

    }

    protected void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/delete.jsp");
        dispatcher.forward(request, response);
    }


    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userDAO.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message", "delete successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/delete.jsp");
        dispatcher.forward(request, response);
    }
}