package com.bookstore.dao;

import com.bookstore.entities.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import java.util.List;

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
    public void testListUsers(){
        List<User> usersList = userDAO.listAll();
        assertFalse(usersList.isEmpty());
    }
    @Test
    public void testCreateUsers() {
        User user1 = new User();
        user1.setEmail("test@gmail.com");
        user1.setFullName("nmisqfd");
        user1.setPassword("Jimmy");

        user1 = userDAO.create(user1);


        assertTrue(user1.getUserId() > 0);
    }
    @Test
    public void updateTest(){
        User toUpdate = userDAO.getUserByName("nmisqfd");
        System.out.println(toUpdate);
        toUpdate.setEmail("panaras254@gmail.com");
        userDAO.update(toUpdate);
        assertEquals("That email changed", "panaras254@gmail.com", toUpdate.getEmail());
    }

    @Test
    public void countUsersTest(){
        long usersCount = userDAO.count();
        assertTrue(usersCount >=0);
    }
    @Test
    public void testDelete(){
        User toDelete = userDAO.getUserByName("nmisqfd");
        Long userToDeleteId = toDelete.getUserId();
        userDAO.delete(userToDeleteId);
        User toCheck = userDAO.get(userToDeleteId);
        assertNull(toCheck);
    }



    @AfterClass
    public static void teardownClass(){
        entityManager.close();
        entityManagerFactory.close();
    }
}