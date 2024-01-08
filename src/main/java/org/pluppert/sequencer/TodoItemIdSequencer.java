package org.pluppert.sequencer;

public class TodoItemIdSequencer implements ISequencer {
    private int currentId = 0;
    private static final TodoItemIdSequencer INSTANCE;

    static {
        INSTANCE = new TodoItemIdSequencer();
    }
    private TodoItemIdSequencer() {}

    public static TodoItemIdSequencer getInstance() {
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
