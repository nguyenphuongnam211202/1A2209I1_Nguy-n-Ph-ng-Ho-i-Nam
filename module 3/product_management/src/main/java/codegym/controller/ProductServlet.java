package codegym.controller;

import codegym.dao.ProductDAO;
import codegym.model.Product;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;




@WebServlet(name = "product", urlPatterns = {"/products",""})
public class ProductServlet extends HttpServlet {


    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
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
                deleteProduct(request,response);
                break;
            default:
                listProduct(request, response);
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
                createProduct(request, response);
                break;
            case " update":
                editProduct(request,response);
                break;
            case "search":
                searchById(request,response);
                break;
            default:
                break;

        }
    }


    protected void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.selectAll();
        request.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
        requestDispatcher.forward(request,response);
    }


    protected void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        List<Product> productList = productDAO.searh(key);
        request.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productDAO.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/products");

    }

    protected void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int cost = Integer.parseInt(request.getParameter("cost"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        String category = request.getParameter("category");
        try {
            productDAO.insertProduct(new Product(name,cost,quantity,color,describe,category));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/products");
    }

    protected void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int cost = Integer.parseInt(request.getParameter("cost"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        String category = request.getParameter("category");
        Product product = new Product(id,name,cost,quantity,color,describe,category);
        try {
            productDAO.updateProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/products");

    }

    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/view/create.jsp");
    }

    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("/view/edit.jsp");
        requestDispatcher.forward(request,response);
    }



}