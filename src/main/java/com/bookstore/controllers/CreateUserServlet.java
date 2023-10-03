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

@WebServlet("/admin/createuser")
public class CreateUserServlet  extends HttpServlet {
    private String message;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        UserServices userServices = new UserServices();



        if(userServices.createUser(fullname,email,password)){
            request.setAttribute("success","success");
            userServices.listUsers(request,response);
        }else{
            request.setAttribute("message","User already exists");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);
        }


    }

    public void destroy() {
    }
}
