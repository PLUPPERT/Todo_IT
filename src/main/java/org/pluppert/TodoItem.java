package org.pluppert;

import org.pluppert.enums.IdType;

import java.time.LocalDate;

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
            throw new IllegalArgumentException("Title can't be 'null' or empty");
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
        if (deadline == null) throw new IllegalArgumentException("Deadline can't be 'null'");
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

    public void setCreator(Person creator) {
        if (creator == null) throw new IllegalArgumentException("Creator can't be 'null'");
        this.creator = creator;
    }

    public boolean isOverdue() {
        return getDeadline().isAfter(LocalDate.now());
    }

    public String getSummary() {
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
}
