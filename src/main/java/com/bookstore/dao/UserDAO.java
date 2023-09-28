package com.bookstore.dao;

import com.bookstore.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO extends JpaDAO<User> implements GenericDao<User> {
    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public User create(User user) {

        return super.create(user);
    }

    @Override
    public User update(User t) {
        return super.update(t);

    }

    @Override
    public User get(Object userId) {
        return super.get(User.class, userId);
    }

    @Override
    public void delete(Object id) {
        super.delete(User.class, id);
    }

    public User getUserByName(String name) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.fullName = :name", User.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<User> listAll() {

        return super.findWithNamedQuery("User.findAll");
    }
    public long count(){
        return super.countWithNamedQuery("User.countAll");
    }
  
}
