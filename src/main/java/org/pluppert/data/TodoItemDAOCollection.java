package org.pluppert.data;

import org.pluppert.data.serializer.JsonReader;
import org.pluppert.data.serializer.JsonWriter;
import org.pluppert.data.serializer.ObjectType;
import org.pluppert.model.TodoItem;

import java.io.IOException;
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

    static TodoItemDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if (todoItem == null) throw new NullPointerException("todoItem is null");
        todoItemList.add(todoItem);
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return List.copyOf(todoItemList);
    }

    @Override
    public void remove(Integer id) {
        todoItemList.remove(findById(id));
    }

    @Override
    public Collection<TodoItem> fetchDataFromFile() {
        return JsonReader.getInstance().read(ObjectType.TODO_ITEM);
    }

    @Override
    public void writeDataToFile(Collection<TodoItem> data) throws IOException {
        JsonWriter.getInstance().write(List.copyOf(data));
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


