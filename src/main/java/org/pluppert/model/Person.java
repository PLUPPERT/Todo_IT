package org.pluppert.model;

import java.util.Objects;

public class Person {

    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName) {
        this.id= 0;
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
                "\tid = " + getId() + ",\n" +
                "\tfirstName = '" + getFirstName() + "',\n" +
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
    public void updateId(Person prevId, int newId) {
        if (prevId.getId() == 0) prevId.setId(newId);
    }
}

