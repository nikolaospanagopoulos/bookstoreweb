package com.bookstore.dao;

import javax.persistence.EntityManager;
import java.awt.geom.GeneralPath;

public class JpaDAO<Type> {
    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Type create(Type t) {

        entityManager.getTransaction().begin();

        entityManager.persist(t);
        entityManager.flush();
        entityManager.refresh(t);

        entityManager.getTransaction().commit();

        return t;
    }
}
