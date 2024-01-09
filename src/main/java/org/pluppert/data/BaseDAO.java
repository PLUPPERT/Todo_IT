package org.pluppert.data;

import java.io.IOException;
import java.util.Collection;

public interface BaseDAO<T, P> {
    T persist(T type);
    Collection<T> findAll();
    void remove(P value);
    Collection<T> fetchDataFromFile();
    void writeDataToFile(Collection<T> data) throws IOException;
}
