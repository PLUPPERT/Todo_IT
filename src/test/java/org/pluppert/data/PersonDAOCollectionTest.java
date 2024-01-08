package org.pluppert.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOCollectionTest {
    PersonDAO INSTANCE;
    @BeforeEach
    void setUp() {
        INSTANCE = PersonDAOCollection.getInstance();
    }
    @Test
    void getInstance() {
    }

    @Test
    void persist() {
    }

    @Test
    void findAll() {
    }

    @Test
    void remove() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByEmail() {
    }
}