package org.pluppert.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean done;
    private Person assignee;
    private Person creator;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public TodoItem(String title, String description, Person creator) {
        setTitle(title);
        setDescription((description == null) ? "" : description);
        setCreator(creator);
        setId(0);
        setDeadline(null);
        setDone(false);
    }
    public TodoItem(String title, String description, LocalDateTime deadline, Person creator) {
        this(title, description, creator);
        setDeadline(deadline);
        setDone(false);
        setCreator(creator);
    }
    public TodoItem(String title, String description, LocalDateTime deadline, Person assignee, Person creator) {
        this(title, description, deadline, creator);
        setId(0);
        setDone(false);
        setAssignee(assignee);
    }
    public TodoItem(String title, String description, LocalDateTime deadline, boolean done, Person assignee, Person creator) {
        this(title, description, deadline, assignee, creator);
        setId(0);
        setDone(done);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        if (deadline != null) {
            String deadlineString = deadline.toString();
            String subString = deadlineString.substring(19);
            String editedDeadline = deadlineString.replace(subString, "").replace("T", " ");
            this.deadline = LocalDateTime.parse(editedDeadline, formatter);
        }
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public Person getCreator() {
        return creator;
    }

    private void setCreator(Person creator) {
        if (creator == null) throw new IllegalArgumentException("Creator can't be set to 'null'");
        this.creator = creator;
    }

    public boolean isOverdue() {
        return getDeadline().isBefore(LocalDateTime.now());
    }

    public void updateId(TodoItem prevId, int newId) {
        if (prevId.getId() == 0) prevId.setId(newId);
    }

    @Override
    public String toString() {
        String getAssignee = getAssignee() == null ? "---" : getAssignee().getFullName();
        String isOverdue = getDeadline() == null ? "---" : String.valueOf(isOverdue());
        var getDeadline = getDeadline() == null ? getDeadline() : getDeadline().format(formatter);

        return "TodoItem {\n" +
                    "\tid = '" + getId() + "',\n" +
                    "\ttitle = '" + getTitle() + "',\n" +
                    "\ttaskDescription = '" + getDescription() + "',\n" +
                    "\tdeadline = " + getDeadline + ",\n" +
                    "\tdone = " + isDone() + ",\n" +
                    "\tisOverdue = " + isOverdue + ",\n" +
                    "\tassignee = " + getAssignee + ",\n" +
                    "\tcreator = '" + getCreator().getFullName() + "',\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id
                && done == todoItem.done
                && Objects.equals(title, todoItem.title)
                && Objects.equals(description, todoItem.description)
                && Objects.equals(deadline, todoItem.deadline)
                && Objects.equals(assignee, todoItem.assignee)
                && Objects.equals(creator, todoItem.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadline, done, assignee, creator);
    }
}
