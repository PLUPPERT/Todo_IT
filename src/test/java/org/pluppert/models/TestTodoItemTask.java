package org.pluppert.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pluppert.sequencer.IdGenerator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TestTodoItemTask {
    TodoItemTask task;
    TodoItem item;
    Person person;
    IdGenerator idGenerator = new IdGenerator();

    @BeforeEach
    public void init() {
        LocalDate deadline = LocalDate.parse("2028-03-29");
        this.person = new Person("Bosse", "Startplugg", "bosse@gmailus.com", idGenerator);
        this.item = new TodoItem(
                "Starta en hamsterklubb",
                "Skapa en klubb för alla som älskar att skryta om sin hamster",
                deadline,
                person,
                idGenerator
        );
        this.task = new TodoItemTask(item, null, idGenerator);
    }

    @Test
    void canGetId() {
        int expectedId = 1;
        assertEquals(expectedId, task.getId());
    }
    @Test
    void canGetIsAssigned() {
        boolean expectedValue = false;
        assertEquals(expectedValue, task.isAssigned());
    }
    @Test
    void isAssignedTurnsTrueIfTaskHasAssignee() {
        boolean expectedValue = true;
        task.setAssignee(person);
        assertEquals(expectedValue, task.isAssigned());
    }
    @Test
    void canGetTodoItem() {
        TodoItem expectedItem = item;
        assertEquals(expectedItem, task.getTodoItem());
    }
    @Test
    void initTodoItemToNullShouldThrowException() {
        IllegalArgumentException thrownByNull = Assertions.assertThrowsExactly(
                IllegalArgumentException.class,
                () -> {
                    //Code under test
                    new TodoItemTask(null, null, idGenerator);
                }, "TodoItem parameter was 'null' : IllegalArgumentException was expected\n");

        Assertions.assertEquals("TodoItem can't be set to 'null'", thrownByNull.getMessage());
    }
    @Test
    void canSetAndGetAssignee() {
        Person expectedAssignee = person;
        task.setAssignee(person);
        assertEquals(expectedAssignee, task.getAssignee());
    }
    @Test
    void canSetAssignee() {
        Person expectedAssignee = person;
        task.setAssignee(person);
        assertEquals(expectedAssignee, task.getAssignee());
    }
    @Test
    void notAbleToSetAssigneeToTaskAlreadyAssigned() {
        Person newAssignee = new Person("Maggan", "Stoppkloss", "maggan@gmaggalicious.xoxo", idGenerator);
        task.setAssignee(person);
        task.setAssignee(newAssignee);
        assertNotEquals(newAssignee, task.getAssignee());
    }
    @Test
    void getSummaryReturnsCorrectString() {
        String assigneeName = (task.getAssignee() == null) ? "null" : task.getAssignee().getFullName();
        String expectedString = "TodoItemTask {\n" +
                "\tid = '" + task.getId() + "',\n" +
                "\tassigned = '" + task.isAssigned() + "',\n" +
                "\ttodoItem = '" + task.getTodoItem().getTitle() + "',\n" +
                "\tassignee = " + assigneeName + ",\n" +
                '}';

        assertEquals(expectedString, task.toString());
    }
}
