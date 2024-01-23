package org.pluppert.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pluppert.sequencer.PersonIdSequencer;

class PersonTest {
    Person person;
    PersonIdSequencer idGen = PersonIdSequencer.getInstance();

    @BeforeEach
    public void setUp() {
        idGen.setCurrentId(0);
        this.person = new Person("Bosse", "Startplugg");
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
    void toStringReturnsCorrectString() {
        String expectedString = "Person {\n" +
                "\tid = " + person.getId() + "," +
                "\t'firstName = '" + person.getFirstName() + "',\n" +
                "\tlastName = '" + person.getLastName() + "',\n" +
                '}';

        assertEquals(expectedString, person.toString());

    }
}
