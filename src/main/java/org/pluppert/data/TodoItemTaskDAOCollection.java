package org.pluppert.data;

import org.pluppert.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private static final TodoItemTaskDAO INSTANCE;

    static {
        INSTANCE = new TodoItemTaskDAOCollection();
    }

    private final List<TodoItemTask> taskList;

    private TodoItemTaskDAOCollection() {
        taskList = new ArrayList<>();
    }

    static TodoItemTaskDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public TodoItemTask persist(TodoItemTask type) {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return List.copyOf(taskList);
    }

    @Override
    public void remove(Integer id) {
        taskList.remove(findById(id));
    }

    @Override
    public TodoItemTask findById(int id) {
        return findAll().stream()
                .filter(task -> task.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return findAll().stream()
                .filter(task -> task.isAssigned() == status)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int id) {
        return findAll().stream()
                .filter(task -> task.getAssignee().getId() == id)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}