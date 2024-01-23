package org.pluppert.model;

import org.pluppert.sequencer.PersonIdSequencer;
import org.pluppert.utils.Utils;



import java.util.Objects;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private static final PersonIdSequencer idGen = PersonIdSequencer.getInstance();

    public Person(String firstName, String lastName) {
        setId(idGen.nextId());
        setFirstName(firstName);
        setLastName(lastName);
    }
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Not allowed to set first name to 'null'");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("Not allowed to set last name to 'null'");
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person {\n" +
                "\tid = " + getId() + "," +
                "\t'firstName = '" + getFirstName() + "',\n" +
                "\tlastName = '" + getLastName() + "',\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public void updatePersonData(String firstName, String lastName, Person person) {
        person.setFirstName(Utils.inst.isNullOrEmpty(firstName) ? person.getFirstName() : firstName);
        person.setLastName(Utils.inst.isNullOrEmpty(lastName) ? person.getLastName() : lastName);
    }
}

