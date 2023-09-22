package com.bookstore.dao;

import com.bookstore.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO extends JpaDAO<User> implements  GenericDao<User> {
    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public User create(User user){
        return super.create(user);
    }

    @Override
    public User update(User t) {
        return null;
    }

    @Override
    public User get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
