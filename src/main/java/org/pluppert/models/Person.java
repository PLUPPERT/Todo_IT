package org.pluppert.models;

import org.pluppert.sequencer.IdGenerator;
import org.pluppert.enums.IdType;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    public Person(String firstName, String lastName, String email, IdGenerator idGenerator, AppUser credentials) {
        setId(idGenerator.getGeneratedId(IdType.PERSON));
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setCredentials(credentials);
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

    private void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Not allowed to set first name to 'null'");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("Not allowed to set last name to 'null'");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Not allowed to set email to 'null'");
        this.email = email;
    }

    private AppUser getCredentials() {
        return credentials;
    }

    private void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Person {\n" +
                "\tid = " + getId() + "," +
                "\t'firstName = '" + getFirstName() + "',\n" +
                "\tlastName = '" + getLastName() + "',\n" +
                "\temail ='" + getEmail() + "'\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}


