package com.example.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import model.calculator;


@WebServlet(name = "calculator", value = "/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("num1"));
        float secondOperand = Integer.parseInt(request.getParameter("num2"));
        String operator = request.getParameter("phepTinh");
        PrintWriter writer = response.getWriter();
        try {
            float result = calculator.calculate(firstOperand, secondOperand, operator);
            request.setAttribute("result",result);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (Exception ex) {
            writer.println("Error: " + ex.getMessage());
        }

    }



}