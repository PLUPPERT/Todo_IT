package org.pluppert.sequencer;

public interface ISequencer<Integer> {
    int nextId();
    int getCurrentId();
    void setCurrentId(int id);
}
