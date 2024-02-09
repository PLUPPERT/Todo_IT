package org.pluppert.data;

import java.util.Collection;

public interface BaseDAO<T> {
    Collection<T> findAll();
}
