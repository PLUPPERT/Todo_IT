package org.pluppert.data;

import org.pluppert.model.Person;

public interface PersonDAO extends BaseDAO<Person, Integer> {
    PersonDAO INSTANCE = PersonDAOCollection.getInstance();
    Person findById(int id);
    Person findByEmail(String email);
}
