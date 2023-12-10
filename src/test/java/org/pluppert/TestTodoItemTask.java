package org.pluppert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTodoItemTask {
    TodoItemTask task;
    TodoItem item;
    Person person;
    IdGenerator idGenerator = new IdGenerator();

    @BeforeEach
    public void initializeInstances() {
        LocalDate deadline = LocalDate.parse("2028-03-29");
        this.person = new Person("Bosse", "Startplugg", "bosse@gmailus.com", idGenerator);
        this.item = new TodoItem("Item 1", "Do whatever, I don't care...", deadline, person, idGenerator);
        this.task = new TodoItemTask(item, null, idGenerator);
    }

    @Test
    void canGetId() {
        int expectedId = 1;
        assertEquals(expectedId, task.getId());
    }
}
