package com.bookstore.controllers;

import com.bookstore.entities.User;
import com.bookstore.services.UserServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminListUsers", value = "/admin/listusers")
public class ListUsersServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserServices userServices = new UserServices();
         userServices.listUsers(request,response);

    }

    public void destroy() {
    }
}
