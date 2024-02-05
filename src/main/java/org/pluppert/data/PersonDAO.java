package org.pluppert.data;

import org.pluppert.data.impl.PersonDAOCollection;
import org.pluppert.model.Person;

import java.util.Collection;

public interface PersonDAO extends BaseDAO<Person> {
    PersonDAO INSTANCE = PersonDAOCollection.getInstance();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);
}
