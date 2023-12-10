package org.pluppert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TestTodoItem {
    TodoItem item;
    Person person;
    IdGenerator idGenerator = new IdGenerator();
    @BeforeEach
    public void initializePersonAndItem() {
        LocalDate deadline = LocalDate.parse("2028-03-29");
        this.person = new Person("Bosse", "Startplugg", "bosse@gmailus.com", idGenerator);
        this.item = new TodoItem("Item 1", "Do whatever, I don't care...", deadline, person, idGenerator);
    }

    @Test
    void canGetId() {
        int expectedId = 1;
        assertEquals(expectedId, item.getId());
    }
    @Test
    void canGetTitle() {
        String expectedTitle = "Item 1";
        assertEquals(expectedTitle, item.getTitle());
    }
    @Test
    void canSetTitle() {
        String expectedTitle = "New Item";
        item.setTitle(expectedTitle);
        assertEquals(expectedTitle, item.getTitle());
    }
    @Test
    void settingTitleToNullOrEmptyShouldThrowException() {
        IllegalArgumentException thrownByNull = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    //Code under test
                    item.setTitle(null);
                }, "Argument was 'null' : \nIllegalArgumentException was expected");
        IllegalArgumentException thrownByEmpty = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    //Code under test
                    item.setTitle("");
                }, "Argument was an empty string : \nIllegalArgumentException was expected");

        Assertions.assertEquals("Title can't be 'null'", thrownByNull.getMessage());
        Assertions.assertEquals("Title can't be empty", thrownByEmpty.getMessage());
    }
    @Test
    void canGetTaskDescription() {
        String expectedDescription = "Do whatever, I don't care...";
        assertEquals(expectedDescription, item.getTaskDescription());
    }
    @Test
    void canSetTaskDescription() {
        String expectedTitle = "Cheer up, mister Poopy Mood! =)";
        item.setTaskDescription(expectedTitle);
        assertEquals(expectedTitle, item.getTaskDescription());
    }
}
