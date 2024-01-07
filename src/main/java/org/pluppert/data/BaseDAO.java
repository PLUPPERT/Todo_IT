package org.pluppert.data;

import java.util.Collection;

public interface BaseDAO<T, P> {
    T persist(T type);
    Collection<T> findAll();
    void remove(P value);
}
