package com.bookstore.services;

import com.bookstore.dao.UserDAO;
import com.bookstore.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServices {
    private UserDAO userDAO;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public UserServices() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }

    public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User>userList = userDAO.listAll();
        request.setAttribute("usersList",userList);

        String page = "listusers.jsp";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request,response);
    }

    public boolean createUser(String fullname, String email, String password){
        if(userDAO.getUserByEmail(email) == null){
            userDAO.create(new User(email,fullname,password));
            return true;
        }
        return false;
    }
}
