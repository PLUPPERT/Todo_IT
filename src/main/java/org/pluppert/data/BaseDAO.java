package org.pluppert.data;

import java.util.Collection;

public interface BaseDAO<T> {
    T persist(T type);
    Collection<T> findAll();
    void remove(T value);
}
