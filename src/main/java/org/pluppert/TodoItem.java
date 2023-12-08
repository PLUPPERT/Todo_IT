package org.pluppert;

import java.time.LocalDate;

public class TodoItem {
    private static int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String taskDescription, LocalDate deadline, Person creator) {
        setTitle(title);
        setCreator(creator);
        setTaskDescription((taskDescription == null) ? "" : taskDescription);
        setDeadline(deadline == null ? LocalDate.now() : deadline);
        setDone(false);
    }
    public static int getId() {
        return id;
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
        final StringBuilder sb = new StringBuilder("TodoItem{\n");
        sb.append("\ttitle = '").append(title).append("',\n");
        sb.append("\ttaskDescription = '").append(taskDescription).append("',\n");
        sb.append("\tdeadline = ").append(deadline).append(",\n");
        sb.append("\tdone = ").append(done).append(",\n");
        sb.append("\tcreator = '").append(creator.getFirstName()).append(" ").append(creator.getLastName()).append("',\n");
        sb.append("\tisOverdue = ").append(isOverdue()).append(",\n");
        sb.append('}');
        return sb.toString();
    }
}
