package org.pluppert.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilsTest {
    @Test
    void isNullOrEmpty() {
        Assertions.assertFalse(Utils.inst.isNullOrEmpty("Blöpp"));
        Assertions.assertTrue(Utils.inst.isNullOrEmpty(""));
        Assertions.assertTrue(Utils.inst.isNullOrEmpty(null));
    }

    @Test
    void invalidPassword() {
        // Should be a valid password
        Assertions.assertFalse(Utils.inst.invalidPassword("mJau125/"));
        // Should be invalid due to password being to short
        Assertions.assertTrue(Utils.inst.invalidPassword("mJau125"));
        // Should be invalid due to lack of special characters
        Assertions.assertTrue(Utils.inst.invalidPassword("mJau1256"));
        // Should be invalid due to lack of uppercase characters
        Assertions.assertTrue(Utils.inst.invalidPassword("mjau125/"));
        // Should be invalid due to lack of lowercase characters
        Assertions.assertTrue(Utils.inst.invalidPassword("MJAU125/"));
        // Should be invalid due to lack of number characters
        Assertions.assertTrue(Utils.inst.invalidPassword("MJAUmjau/"));
    }
}
