package com.bookstore.dao;

import java.util.List;

public interface GenericDao<Type> {
    public Type create(Type t);

    public Type update(Type t);

    public Type get(Object id);

    public void delete(Object id);

    public List<Type> listAll();

    public long count();
}
