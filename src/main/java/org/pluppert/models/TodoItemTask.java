package org.pluppert.models;

import org.pluppert.sequencer.IdGenerator;
import org.pluppert.enums.IdType;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee, IdGenerator idGenerator) {
        setId(idGenerator.getGeneratedId(IdType.TASK));
        setTodoItem(todoItem);
        setAssignee(assignee);
    }

    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    public boolean isAssigned() {
        return assigned;
    }
    private void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    public TodoItem getTodoItem() {
        return todoItem;
    }
    private void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("TodoItem can't be set to 'null'");
        this.todoItem = todoItem;
    }
    public Person getAssignee() {
        return assignee;
    }
    public void setAssignee(Person assignee) {
        if (!isAssigned()) {
            setAssigned(assignee != null);
            this.assignee = assignee;
        } else {
            System.out.println("This task is already assigned to: " + getAssignee().getFullName());
        }
    }

    public String getSummary() {
        String assigneeName = (getAssignee() == null) ? "null" : getAssignee().getFullName();
        return "TodoItemTask {\n" +
                    "\tid = '" + getId() + "',\n" +
                    "\tassigned = '" + isAssigned() + "',\n" +
                    "\ttodoItem = '" + getTodoItem().getTitle() + "',\n" +
                    "\tassignee = " + assigneeName + ",\n" +
                '}';
    }
}
