package org.pluppert.sequencer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pluppert.enums.AppRole;
import org.pluppert.enums.IdType;
import org.pluppert.model.AppUser;
import org.pluppert.model.Person;
import org.pluppert.model.TodoItem;
import org.pluppert.model.TodoItemTask;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdGeneratorTest {
    Person person;
    TodoItem item;
    TodoItemTask task;

    @BeforeEach
    void setUp() {
        IdGenerator.resetPersonIdCounter();
    }

    @Test
    void incrementsPersonId() {
        int expectedId = 3;
        IdGenerator.getInstance().getGeneratedId(IdType.PERSON);
        IdGenerator.getInstance().getGeneratedId(IdType.PERSON);
        person = new Person(
                "Mjau",
                "Kattsson",
                "mjau_katts@gmjau.se",
                new AppUser("KattusMjaus", "nEwPoKeBoY2000!", AppRole.ROLE_APP_USER));
        assertEquals(expectedId, person.getId());
    }
    @Test
    void incrementsItemId() {
        int expectedId = 3;
        IdGenerator.getInstance().getGeneratedId(IdType.ITEM);
        IdGenerator.getInstance().getGeneratedId(IdType.ITEM);
        person = new Person(
                "Mjau",
                "Kattsson",
                "mjau_katts@gmjau.se",
                new AppUser("KattusMjaus", "nEwPoKeBoY2000!", AppRole.ROLE_APP_USER));
        item = new TodoItem(
                "Starta en hamsterklubb",
                "Skapa en klubb för alla som älskar att skryta om sin hamster",
                LocalDate.parse("2028-03-29"),
                person);
        assertEquals(expectedId, item.getId());
    }
    @Test
    void incrementsTaskId() {
        int expectedId = 3;
        IdGenerator.getInstance().getGeneratedId(IdType.TASK);
        IdGenerator.getInstance().getGeneratedId(IdType.TASK);
        person = new Person(
                "Mjau",
                "Kattsson",
                "mjau_katts@gmjau.se",
                new AppUser("KattusMjaus", "nEwPoKeBoY2000!", AppRole.ROLE_APP_USER));
        item = new TodoItem(
                "Starta en hamsterklubb",
                "Skapa en klubb för alla som älskar att skryta om sin hamster",
                LocalDate.parse("2028-03-29"),
                person);
        task = new TodoItemTask(item, null);
        assertEquals(expectedId, task.getId());
    }
}
