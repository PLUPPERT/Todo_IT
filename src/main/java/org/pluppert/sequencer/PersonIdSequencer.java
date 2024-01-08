package org.pluppert.sequencer;

public class PersonIdSequencer implements ISequencer<Integer> {
    private int currentId = 0;
    private static final PersonIdSequencer INSTANCE;

    static {
        INSTANCE = new PersonIdSequencer();
    }
    private PersonIdSequencer() {}

    public static PersonIdSequencer getInstance() {
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
