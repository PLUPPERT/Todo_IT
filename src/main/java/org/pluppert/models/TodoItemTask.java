package org.pluppert.models;

import org.pluppert.sequencer.IdGenerator;
import org.pluppert.enums.IdType;

import java.util.Objects;

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

    @Override
    public String toString() {
        String assigneeName = (getAssignee() == null) ? "null" : getAssignee().getFullName();
        return "TodoItemTask {\n" +
                    "\tid = '" + getId() + "',\n" +
                    "\tassigned = '" + isAssigned() + "',\n" +
                    "\ttodoItem = '" + getTodoItem().getTitle() + "',\n" +
                    "\tassignee = " + assigneeName + ",\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id && assigned == that.assigned && Objects.equals(todoItem, that.todoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }
}
