package org.pluppert.data.impl;

import org.pluppert.data.PersonDAO;
import org.pluppert.data.TodoItemDAO;
import org.pluppert.db.MyJDBC;
import org.pluppert.model.Person;
import org.pluppert.model.TodoItem;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO {
    private static final TodoItemDAO INSTANCE;
    private static final PersonDAO PERSON_INST;
    private static final Connection connection;

    static {
        INSTANCE = new TodoItemDAOCollection();
        PERSON_INST = new PersonDAOCollection();
        connection = MyJDBC.getConnection();
    }

    public static TodoItemDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public TodoItem createItem(TodoItem todoItem) {
        if (todoItem == null) throw new NullPointerException("todoItem is null");
        int creatorId = todoItem.getCreator().getId();

        Optional<Person> optCreator = Optional.of(PERSON_INST.findById(creatorId));
        Person creator = optCreator.orElseThrow(() ->
                new IllegalArgumentException("No person with id '" + creatorId + "' in database.")
        );

        String insertQuery = "INSERT INTO todo_item (title, description, deadline, done, assignee_id, creator_id) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)
        ) {
            var deadline = todoItem.getDeadline() == null ?
                    null : Timestamp.valueOf(todoItem.getDeadline());

            var assignee = todoItem.getAssignee() == null ? 0 : todoItem.getAssignee().getId();

            preparedStatement.setString(1, todoItem.getTitle());
            preparedStatement.setString(2, todoItem.getDescription());
            preparedStatement.setTimestamp(3, deadline);
            preparedStatement.setBoolean(4, todoItem.isDone());
            if (assignee <= 0) {
                preparedStatement.setNull(5, assignee);
            } else {
                preparedStatement.setInt(5, assignee);
            }
            preparedStatement.setInt(6, creator.getId());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Todo Item created successfully!");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedItemId = generatedKeys.getInt(1);
                    todoItem.updateId(todoItem, generatedItemId);
                } else {
                    System.out.println("No key were genereated");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findAll() {
        List<TodoItem> items = new ArrayList<>();

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM todo_item")
        ) {
            while (resultSet.next()) {
                //ColumnLabel
                int itemId = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                var deadline = resultSet.getTimestamp(4) == null ?
                        null : resultSet.getTimestamp(4).toLocalDateTime();
                boolean done = resultSet.getBoolean(5);
                int assigneeId = resultSet.getInt(6);
                var assignee = assigneeId == 0 ? null : PERSON_INST.findById(assigneeId);
                int creatorId = resultSet.getInt(7);

                TodoItem foundItem = new TodoItem(
                        title,
                        description,
                        deadline,
                        done,
                        assignee,
                        PERSON_INST.findById(creatorId)
                );

                foundItem.updateId(foundItem, itemId);

                items.add(foundItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public TodoItem findById(int id) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM todo_item WHERE todo_id = ?"
                )
        ) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    var deadline = resultSet.getTimestamp(4) == null ?
                            null : resultSet.getTimestamp(4).toLocalDateTime();

                    var assignee = resultSet.getInt(6) <= 0 ? null :
                            PERSON_INST.findById(resultSet.getInt(6));

                    TodoItem itemFound = new TodoItem(
                            resultSet.getString("title"),
                            resultSet.getString("description"),
                            deadline,
                            resultSet.getBoolean("done"),
                            assignee,
                            PERSON_INST.findById(resultSet.getInt("creator_id"))
                    );
                    itemFound.updateId(itemFound, resultSet.getInt("todo_id"));

                    return itemFound;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("No TodoItem with id \"" + id + "\" found in database");
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
    public Collection<TodoItem> findByDeadlineBefore(LocalDateTime date) {
        return findAll().stream()
                .filter(todoItem -> todoItem.getDeadline().isBefore(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDateTime date) {
        return findAll().stream()
                .filter(todoItem -> todoItem.getDeadline().isAfter(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}


