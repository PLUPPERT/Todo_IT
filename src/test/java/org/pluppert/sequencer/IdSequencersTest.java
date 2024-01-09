package org.pluppert.sequencer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pluppert.model.AppRole;
import org.pluppert.model.AppUser;
import org.pluppert.model.Person;
import org.pluppert.model.TodoItem;
import org.pluppert.model.TodoItemTask;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdSequencersTest {
    Person person;
    TodoItem item;
    TodoItemTask task;
    PersonIdSequencer idGenPerson = PersonIdSequencer.getInstance();
    TodoItemIdSequencer idGenItem = TodoItemIdSequencer.getInstance();
    TodoItemTaskIdSequencer idGenTask = TodoItemTaskIdSequencer.getInstance();

    @BeforeEach
    void setUp() {
        idGenPerson.setCurrentId(0);
        idGenItem.setCurrentId(0);
        idGenTask.setCurrentId(0);
    }

    @Test
    void incrementsPersonId() {
        int expectedId = 3;
        idGenPerson.nextId();
        idGenPerson.nextId();
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
        idGenItem.nextId();
        idGenItem.nextId();
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
        idGenTask.nextId();
        idGenTask.nextId();
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
