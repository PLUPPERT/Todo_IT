package org.pluppert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPerson {
    Person person;
    IdGenerator idGenerator = new IdGenerator();

    @BeforeEach
    public void initializePerson() {
        this.person = new Person("Bosse", "Startplugg", "bosse@gmailus.com", idGenerator);
    }
    @Test
    void canGetId() {
        int expectedId = 1;
        assertEquals(expectedId, person.getId());
    }
    @Test
    void canGetFirstName() {
        String expectedFirstName = "Bosse";
        String firstNameReturned = person.getFirstName();

        assertEquals(expectedFirstName, firstNameReturned);
    }

    @Test
    void canSetFirstName() {
        String expectedFirstName = "Mjau";
        person.setFirstName(expectedFirstName);
        String firstNameReturned = person.getFirstName();

        assertEquals(expectedFirstName, firstNameReturned);
    }
    @Test
    void testSetFirstNameExpectedException() {
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
            //Code under test
            person.setFirstName(null);
        }, "IllegalArgumentException was expected");

        Assertions.assertEquals("Not allowed to set first name to 'null'", thrown.getMessage());
    }
    @Test
    void canGetLastName() {
        String expectedLastName = "Startplugg";
        String lastNameReturned = person.getLastName();

        assertEquals(expectedLastName, lastNameReturned);
    }
    @Test
    void canSetLastName() {
        String expectedLastName = "Mjau";
        person.setLastName(expectedLastName);
        String lastNameReturned = person.getLastName();

        assertEquals(expectedLastName, lastNameReturned);
    }
    @Test
    void testSetLastNameExpectedException() {
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    //Code under test
                    person.setLastName(null);
                }, "IllegalArgumentException was expected");

        Assertions.assertEquals("Not allowed to set last name to 'null'", thrown.getMessage());
    }

    @Test
    void canGetEmail() {
        String expectedEmail = "bosse@gmailus.com";
        String emailReturned = person.getEmail();

        assertEquals(expectedEmail, emailReturned);
    }
    @Test
    void canSetEmail() {
        String expectedEmail = "bosse@gmailus.se";
        person.setEmail("bosse@gmailus.se");
        String emailReturned = person.getEmail();
        assertEquals(expectedEmail, emailReturned);
    }
    @Test
    void testEmailExpectedException() {
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    //Code under test
                    person.setEmail(null);
                }, "IllegalArgumentException was expected");

        Assertions.assertEquals("Not allowed to set email to 'null'", thrown.getMessage());
    }
    @Test
    void getSummaryReturnsCorrectString() {
        String expectedString = "Person {\n" +
                "\tid = " + person.getId() + "," +
                "\t'firstName = '" + person.getFirstName() + "',\n" +
                "\tlastName = '" + person.getLastName() + "',\n" +
                "\temail ='" + person.getEmail() + "'\n" +
                '}';
        String actualString = person.getSummary();

        assertEquals(expectedString, actualString);
    }
}
