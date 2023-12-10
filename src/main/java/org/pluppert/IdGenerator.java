package org.pluppert;

import org.pluppert.enums.IdType;

public class IdGenerator {
    private static int personId;
    private static int itemId;
    private static int taskId;

    public IdGenerator() {
        setPersonId(0);
        setItemId(0);
        setTaskId(0);
    }

    public int getGeneratedId(IdType idType) {
        IdGeneratorMethod idGen = (int counter) -> ++counter;
        return switch (idType) {
            case PERSON -> {
                setPersonId(idGen.generateId(getPersonId()));
                yield getPersonId();
            }
            case ITEM -> {
                setItemId(idGen.generateId(getItemId()));
                yield getItemId();
            }
            case TASK -> {
                setTaskId(idGen.generateId(getTaskId()));
                yield getTaskId();
            }
        };
    }

    public static int getPersonId() {
        return personId;
    }

    private static void setPersonId(int personId) {
        IdGenerator.personId = personId;
    }

    public static int getItemId() {
        return itemId;
    }

    private static void setItemId(int itemId) {
        IdGenerator.itemId = itemId;
    }

    public static int getTaskId() {
        return taskId;
    }

    private static void setTaskId(int taskId) {
        IdGenerator.taskId = taskId;
    }
}

@FunctionalInterface
interface IdGeneratorMethod {
    int generateId(int counter);
}