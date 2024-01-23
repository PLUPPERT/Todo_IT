package org.pluppert.data;

import java.util.Collection;

public interface BaseDAO<T> {
    T create(T type);
    Collection<T> findAll();
}
