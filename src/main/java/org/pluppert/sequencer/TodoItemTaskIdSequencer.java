package org.pluppert.sequencer;

public class TodoItemTaskIdSequencer implements ISequencer {
    private int currentId = 0;
    private static final TodoItemTaskIdSequencer INSTANCE;

    static {
        INSTANCE = new TodoItemTaskIdSequencer();
    }
    private TodoItemTaskIdSequencer() {}

    public static TodoItemTaskIdSequencer getInstance() {
        return INSTANCE;
    }

    @Override
    public int nextId() {
        setCurrentId(++currentId);
        return getCurrentId();
    }

    @Override
    public int getCurrentId() {
        return currentId;
    }

    @Override
    public void setCurrentId(int id) {
        currentId = id;
    }
}
