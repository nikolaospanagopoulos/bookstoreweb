package com.bookstore.controllers;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hel!!!!lo!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("PPPPP!!!");
        String page = "frontend/index.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request,response);
    }

    public void destroy() {
    }
}