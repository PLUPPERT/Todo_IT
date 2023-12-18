package org.pluppert.models;

import org.pluppert.sequencer.IdGenerator;
import org.pluppert.enums.IdType;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String taskDescription, LocalDate deadline, Person creator, IdGenerator idGenerator) {
        setId(idGenerator.getGeneratedId(IdType.ITEM));
        setTitle(title);
        setCreator(creator);
        setTaskDescription((taskDescription == null) ? "" : taskDescription);
        setDeadline(deadline == null ? LocalDate.now() : deadline);
        setDone(false);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if ((title == null) || title.isEmpty()) {
            String message = (title != null) ? "Title can't be empty" : "Title can't be 'null'";
            throw new IllegalArgumentException(message);
        }
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        if (deadline == null) throw new IllegalArgumentException("Deadline can't be set to 'null'");
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    private void setCreator(Person creator) {
        if (creator == null) throw new IllegalArgumentException("Creator can't be set to 'null'");
        this.creator = creator;
    }

    public boolean isOverdue() {
        return getDeadline().isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "TodoItem {\n" +
                    "\tid = '" + getId() + "',\n" +
                    "\ttitle = '" + getTitle() + "',\n" +
                    "\ttaskDescription = '" + getTaskDescription() + "',\n" +
                    "\tdeadline = " + getDeadline() + ",\n" +
                    "\tdone = " + isDone() + ",\n" +
                    "\tcreator = '" + getCreator().getFirstName() + " " + getCreator().getLastName() + "',\n" +
                    "\tisOverdue = " + isOverdue() + ",\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadline, done);
    }
}
