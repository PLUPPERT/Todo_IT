package org.pluppert;

import org.pluppert.enums.IdType;

public class IdGenerator {
    private static int personId;
    private static int todoItemId;
    private static int todoItemTaskId;

    public IdGenerator() {
        setPersonId(0);
        setTodoItemId(0);
        setTodoItemTaskId(0);
    }

    public int getGeneratedId(IdType idType) {
        IdGeneratorMethod idGen = (int counter) -> ++counter;
        return switch (idType) {
            case PERSON -> {
                setPersonId(idGen.generateId(getPersonId()));
                yield getPersonId();
            }
            case ITEM -> {
                setTodoItemId(idGen.generateId(getTodoItemId()));
                yield getTodoItemId();
            }
            case TASK -> {
                setTodoItemTaskId(idGen.generateId(getTodoItemTaskId()));
                yield getTodoItemTaskId();
            }
        };
    }

    public static int getPersonId() {
        return personId;
    }

    private static void setPersonId(int personId) {
        IdGenerator.personId = personId;
    }

    public static int getTodoItemId() {
        return todoItemId;
    }

    private static void setTodoItemId(int todoItemId) {
        IdGenerator.todoItemId = todoItemId;
    }

    public static int getTodoItemTaskId() {
        return todoItemTaskId;
    }

    private static void setTodoItemTaskId(int todoItemTaskId) {
        IdGenerator.todoItemTaskId = todoItemTaskId;
    }
}

@FunctionalInterface
interface IdGeneratorMethod {
    int generateId(int counter);
}