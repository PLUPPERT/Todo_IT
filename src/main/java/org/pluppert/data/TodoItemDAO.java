package org.pluppert.data;

import org.pluppert.data.impl.TodoItemDAOCollection;
import org.pluppert.model.Person;
import org.pluppert.model.TodoItem;

import java.time.LocalDateTime;
import java.util.Collection;

public interface TodoItemDAO extends BaseDAO<TodoItem> {
    TodoItemDAO INSTANCE = TodoItemDAOCollection.getInstance();
    TodoItem create(TodoItem item);
    TodoItem findById(int id);
    Collection<TodoItem> findByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByAssignee(int id);
    Collection<TodoItem> findByAssignee(Person person);
    Collection<TodoItem> findByUnassigned();
    Collection<TodoItem> findByDeadlineBefore(LocalDateTime date);
    Collection<TodoItem> findByDeadlineAfter(LocalDateTime date);
    TodoItem update(TodoItem item);
    boolean deleteById(int id);
}
