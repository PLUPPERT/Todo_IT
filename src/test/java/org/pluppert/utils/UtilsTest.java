package org.pluppert.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilsTest {
    Utils utils;
    @BeforeEach
    void setUp() {
        utils = new Utils();
    }
    @Test
    void isNullOrEmpty() {
        Assertions.assertFalse(utils.isNullOrEmpty("Blöpp"));
        Assertions.assertTrue(utils.isNullOrEmpty(""));
        Assertions.assertTrue(utils.isNullOrEmpty(null));
    }

    @Test
    void invalidPassword() {
        // Should be a valid password
        Assertions.assertFalse(utils.invalidPassword("mJau125/"));
        // Should be invalid due to password being to short
        Assertions.assertTrue(utils.invalidPassword("mJau125"));
        // Should be invalid due to lack of special characters
        Assertions.assertTrue(utils.invalidPassword("mJau1256"));
        // Should be invalid due to lack of uppercase characters
        Assertions.assertTrue(utils.invalidPassword("mjau125/"));
        // Should be invalid due to lack of lowercase characters
        Assertions.assertTrue(utils.invalidPassword("MJAU125/"));
        // Should be invalid due to lack of number characters
        Assertions.assertTrue(utils.invalidPassword("MJAUmjau/"));
    }
}
