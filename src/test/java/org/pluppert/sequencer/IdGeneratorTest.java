package org.pluppert.sequencer;

import org.junit.jupiter.api.Test;
import org.pluppert.enums.AppRole;
import org.pluppert.enums.IdType;
import org.pluppert.models.AppUser;
import org.pluppert.models.Person;
import org.pluppert.models.TodoItem;
import org.pluppert.models.TodoItemTask;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdGeneratorTest {
    Person person;
    TodoItem item;
    TodoItemTask task;
    IdGenerator idGenerator = new IdGenerator();

    @Test
    void incrementsPersonId() {
        int expectedId = 3;
        idGenerator.getGeneratedId(IdType.PERSON);
        idGenerator.getGeneratedId(IdType.PERSON);
        person = new Person(
                "Mjau",
                "Kattsson",
                "mjau_katts@gmjau.se",
                new AppUser("KattusMjaus", "nEwPoKeBoY2000!", AppRole.ROLE_APP_USER),
                idGenerator);
        assertEquals(expectedId, person.getId());
    }
    @Test
    void incrementsItemId() {
        int expectedId = 3;
        idGenerator.getGeneratedId(IdType.ITEM);
        idGenerator.getGeneratedId(IdType.ITEM);
        person = new Person(
                "Mjau",
                "Kattsson",
                "mjau_katts@gmjau.se",
                new AppUser("KattusMjaus", "nEwPoKeBoY2000!", AppRole.ROLE_APP_USER),
                idGenerator);
        item = new TodoItem(
                "Starta en hamsterklubb",
                "Skapa en klubb för alla som älskar att skryta om sin hamster",
                LocalDate.parse("2028-03-29"),
                person,
                idGenerator);
        assertEquals(expectedId, item.getId());
    }
    @Test
    void incrementsTaskId() {
        int expectedId = 3;
        idGenerator.getGeneratedId(IdType.TASK);
        idGenerator.getGeneratedId(IdType.TASK);
        person = new Person(
                "Mjau",
                "Kattsson",
                "mjau_katts@gmjau.se",
                new AppUser("KattusMjaus", "nEwPoKeBoY2000!", AppRole.ROLE_APP_USER),
                idGenerator);
        item = new TodoItem(
                "Starta en hamsterklubb",
                "Skapa en klubb för alla som älskar att skryta om sin hamster",
                LocalDate.parse("2028-03-29"),
                person,
                idGenerator);
        task = new TodoItemTask(item, null, idGenerator);
        assertEquals(expectedId, task.getId());
    }
}
