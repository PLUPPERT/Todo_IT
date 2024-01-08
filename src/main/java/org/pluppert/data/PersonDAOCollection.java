package org.pluppert.data;

import org.pluppert.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDAO {
    private static final PersonDAO INSTANCE;

    static {
        INSTANCE = new PersonDAOCollection();
    }

    private final List<Person> personList;

    private PersonDAOCollection() {
        personList = new ArrayList<>();
    }

    static PersonDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Person persist(Person person) {
        if (person == null) throw new NullPointerException("person is null");
        personList.add(person);
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        return List.copyOf(personList);
    }

    @Override
    public void remove(Integer id) {
        personList.remove(findById(id));
    }

    @Override
    public Person findById(int id) {
        return findAll().stream()
                .filter(person -> person.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public Person findByEmail(String email) {
        return findAll().stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst().orElse(null);
    }
}
