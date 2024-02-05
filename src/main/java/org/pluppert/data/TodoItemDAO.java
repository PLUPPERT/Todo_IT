package org.pluppert.data;

import org.pluppert.data.impl.TodoItemDAOCollection;
import org.pluppert.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends BaseDAO<TodoItem> {
    TodoItemDAO INSTANCE = TodoItemDAOCollection.getInstance();
    TodoItem findById(int id);
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int id);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadlineAfter(LocalDate date);
}
