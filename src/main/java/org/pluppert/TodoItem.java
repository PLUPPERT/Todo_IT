package org.pluppert;

import java.time.LocalDate;

public class TodoItem {
    private static int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, Person creator) {
        setTitle(title);
        setCreator(creator);
    }
    public TodoItem(String title, Person creator, String taskDescription) {
        this(title, creator);
        setTaskDescription(taskDescription);
    }
    public TodoItem(String title, Person creator, LocalDate deadLine) {
        this(title, creator);
        setDeadLine(deadLine);
    }
    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        this(title, creator);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
    }
    public static int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public LocalDate getDeadLine() {
        return deadLine;
    }
    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
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
        this.creator = creator;
    }
}
