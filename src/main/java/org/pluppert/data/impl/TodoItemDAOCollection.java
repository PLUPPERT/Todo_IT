package org.pluppert.data.impl;

import org.pluppert.data.TodoItemDAO;
import org.pluppert.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO {
    private static final TodoItemDAO INSTANCE;

    static {
        INSTANCE = new TodoItemDAOCollection();
    }

    private final List<TodoItem> todoItemList;

    private TodoItemDAOCollection() {
        todoItemList = new ArrayList<>();
    }

    public static TodoItemDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public TodoItem create(TodoItem todoItem) {
        if (todoItem == null) throw new NullPointerException("todoItem is null");
        todoItemList.add(todoItem);
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return List.copyOf(todoItemList);
    }

    @Override
    public TodoItem findById(int id) {
        return findAll().stream()
                .filter(todoItem -> todoItem.getId() == id)
                .findAny().orElse(null);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return findAll().stream()
                .filter(todoItem -> todoItem.isDone() == done)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return findAll().stream()
                .filter(todoItem -> todoItem.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByPersonId(int id) {
        return findAll().stream()
                .filter(todoItem -> todoItem.getCreator().getId() == id)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return findAll().stream()
                .filter(todoItem -> todoItem.getDeadline().isBefore(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return findAll().stream()
                .filter(todoItem -> todoItem.getDeadline().isAfter(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}


