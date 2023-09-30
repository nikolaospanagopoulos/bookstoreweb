package com.bookstore.services;

import com.bookstore.dao.UserDAO;
import com.bookstore.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public List<User> listUsers() {
        return userDAO.listAll();
    }
}
