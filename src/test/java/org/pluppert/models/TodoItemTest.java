package org.pluppert.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pluppert.enums.AppRole;
import org.pluppert.sequencer.IdGenerator;

import java.time.LocalDate;

class TodoItemTest {
    TodoItem item;
    Person person;
    IdGenerator idGenerator = new IdGenerator();
    @BeforeEach
    public void setUp() {
        LocalDate deadline = LocalDate.parse("2028-03-29");
        this.person = new Person("Bosse",
                "Startplugg",
                "bosse@gmailus.com",
                new AppUser("NewNewMon", "nEwPoKeBoY2000!", AppRole.ROLE_APP_ADMIN),
                idGenerator);
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
    @Test
    void canGetDeadline() {
        LocalDate expectedDeadline = LocalDate.parse("2028-03-29");
        assertEquals(expectedDeadline, item.getDeadline());
    }
    @Test
    void canSetDeadline() {
        LocalDate expectedDeadline = LocalDate.parse("2028-03-10");
        item.setDeadline(expectedDeadline);
        assertEquals(expectedDeadline, item.getDeadline());
    }
    @Test
    void settingDeadlineToNullShouldThrowException() {
        IllegalArgumentException thrownByNull = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    //Code under test
                    item.setDeadline(null);
                }, "Argument was 'null' : IllegalArgumentException was expected\n");

        Assertions.assertEquals("Deadline can't be set to 'null'", thrownByNull.getMessage());
    }
    @Test
    void canGetIsDone() {
        boolean expectedValue = false;
        assertEquals(expectedValue, item.isDone());
    }
    @Test
    void canSetDone() {
        boolean expectedValue = true;
        item.setDone(true);
        assertEquals(expectedValue, item.isDone());
    }
    @Test
    void canGetCreator() {
        Person expectedPerson = person;
        assertEquals(expectedPerson, item.getCreator());
    }
    @Test
    void initCreatorToNullShouldThrowException() {
        IllegalArgumentException thrownByNull = Assertions.assertThrowsExactly(
                IllegalArgumentException.class,
                () -> {
                    //Code under test
                    new TodoItem("Item 1", "Do whatever, I don't care...", item.getDeadline(), null, idGenerator);
                }, "Creator parameter was 'null' : IllegalArgumentException was expected\n");

        Assertions.assertEquals("Creator can't be set to 'null'", thrownByNull.getMessage());
    }
    @Test
    void isOverdueReturnsCorrectValue() {
        boolean expectedValue = true;
        item.setDeadline(LocalDate.parse("2020-03-10"));
        assertEquals(expectedValue, item.isOverdue());
    }
    @Test
    void getSummaryReturnsCorrectString() {
        String expectedString = "TodoItem {\n" +
                "\tid = '" + item.getId() + "',\n" +
                "\ttitle = '" + item.getTitle() + "',\n" +
                "\ttaskDescription = '" + item.getTaskDescription() + "',\n" +
                "\tdeadline = " + item.getDeadline() + ",\n" +
                "\tdone = " + item.isDone() + ",\n" +
                "\tcreator = '" + item.getCreator().getFirstName() + " " + item.getCreator().getLastName() + "',\n" +
                "\tisOverdue = " + item.isOverdue() + ",\n" +
                '}';

        assertEquals(expectedString, item.toString());
    }
}
