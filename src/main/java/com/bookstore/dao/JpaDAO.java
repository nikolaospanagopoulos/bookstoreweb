package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class JpaDAO<E> {
    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E create(E t) {

        entityManager.getTransaction().begin();

        entityManager.persist(t);
        entityManager.flush();
        entityManager.refresh(t);

        entityManager.getTransaction().commit();

        return t;
    }

    public E update(E entity) {
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public E get(Class<E> type, Object id) {
        E entity = entityManager.find(type, id);
        if (entity != null) {
            entityManager.refresh(entity);
        }

        return entity;
    }

    public void delete(Class<E> type, Object id) {
        entityManager.getTransaction().begin();
        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();
    }
    public List<E> findWithNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }
    public List<E> findWithNamedQuery(String queryName, String paramName, String paramValue){
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName,paramValue);
        return query.getResultList();
    }
    public long countWithNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery(queryName);
        return (long) query.getSingleResult();
    }
}
