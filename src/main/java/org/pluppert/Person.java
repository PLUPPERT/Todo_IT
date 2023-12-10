package org.pluppert;

import org.pluppert.enums.IdType;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email, IdGenerator idGenerator) {
        setId(idGenerator.getGeneratedId(IdType.PERSON));
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
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
    public String getSummary() {
        return "Person {\n" +
                "\tid = " + getId() + "," +
                "\t'firstName = '" + getFirstName() + "',\n" +
                "\tlastName = '" + getLastName() + "',\n" +
                "\temail ='" + getEmail() + "'\n" +
                '}';
    }
}


