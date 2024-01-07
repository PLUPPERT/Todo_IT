package org.pluppert.sequencer;

import org.pluppert.enums.IdType;

public class IdGenerator {
    private static volatile IdGenerator instance = null;
    private static int personId;
    private static int itemId;
    private static int taskId;

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        if (instance == null) {
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                    personId = 0;
                    itemId = 0;
                    taskId = 0;
                }
            }
        }
        return instance;
    }
    public int getGeneratedId(IdType idType) {
        IdGeneratorMethod idGen = (int counter) -> ++counter;
        return switch (idType) {
            case PERSON -> {
                setPersonId(idGen.generateId(personId));
                yield personId;
            }
            case ITEM -> {
                setItemId(idGen.generateId(itemId));
                yield itemId;
            }
            case TASK -> {
                setTaskId(idGen.generateId(taskId));
                yield taskId;
            }
        };
    }
    private static void setPersonId(int personId) {
        IdGenerator.personId = personId;
    }

    private static void setItemId(int itemId) {
        IdGenerator.itemId = itemId;
    }

    private static void setTaskId(int taskId) {
        IdGenerator.taskId = taskId;
    }
    public static void resetPersonIdCounter() {
        personId = 0;
    }
    public static void resetTaskIdCounter() {
        taskId = 0;
    }
    public static void resetItemIdCounter() {
        itemId = 0;
    }
}

@FunctionalInterface
interface IdGeneratorMethod {
    int generateId(int counter);
}