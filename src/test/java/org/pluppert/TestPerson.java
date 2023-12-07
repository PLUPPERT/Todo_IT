package org.pluppert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestPerson {
    Person person = new Person("Bosse", "Startplugg", "bosse@gmailus.com");

    @Test
    void canGetFirstName() {
        String expectedFirstName = "Bosse";
        String firstNameReturned = person.getFirstName();

        assertEquals(expectedFirstName, firstNameReturned);
    }

}
