package org.pluppert.model;

import org.pluppert.enums.AppRole;
import org.pluppert.sequencer.PersonIdSequencer;
import org.pluppert.utils.Utils;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;
    private final Utils utils = new Utils();
    private static final PersonIdSequencer idGen = PersonIdSequencer.getInstance();

    public Person(String firstName, String lastName, String email, AppUser credentials) {
        setId(idGen.nextId());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public void updatePersonData(String firstName, String lastName, String email, Person person) throws IllegalAccessException {
        if (!hasUserRights(person)) throw new IllegalAccessException("User does not have the rights to update the data of this Person object");
        person.setFirstName(utils.isNullOrEmpty(firstName) ? person.getFirstName() : firstName);
        person.setLastName(utils.isNullOrEmpty(lastName) ? person.getLastName() : lastName);
        person.setEmail(utils.isNullOrEmpty(email) ? person.getEmail() : email);
    }

    public boolean hasUserRights(Person person) {
        if (this.credentials.getRole() == AppRole.ROLE_APP_ADMIN) {
            return true;
        }
        return equals(person) && (person.getCredentials().getRole() == AppRole.ROLE_APP_USER);
    }
}

