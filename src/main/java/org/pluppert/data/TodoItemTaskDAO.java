package org.pluppert.data;

import org.pluppert.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO extends BaseDAO<TodoItemTask, Integer> {
    TodoItemDAO INSTANCE = TodoItemDAOCollection.getInstance();
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int id);
}
