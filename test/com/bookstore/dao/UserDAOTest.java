package com.bookstore.dao;

import com.bookstore.entities.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import static org.junit.Assert.*;

public class UserDAOTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private static UserDAO userDAO;



    @BeforeClass
    public static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }

    @Test
    public void testCreateUsers() {
        User user1 = new User();
        user1.setEmail("test@gmail.com");
        user1.setFullName("nikos p test");
        user1.setPassword("Jimmy");

        user1 = userDAO.create(user1);


        assertTrue(user1.getUserId() > 0);
    }

    @Test(expected = PersistenceException.class)
    public void testCreateUserFieldsNotSet() {
        User user2 = new User();


        user2 = userDAO.create(user2);


        assertTrue(user2.getUserId() > 0);
    }

    @AfterClass
    public static void teardownClass(){
        entityManager.close();
        entityManagerFactory.close();
    }
}