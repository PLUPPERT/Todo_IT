package org.pluppert.data;

import java.util.Optional;

public interface BaseDao<T, ID> {
    T create(T value);
    Optional<T> find(ID id);
}
