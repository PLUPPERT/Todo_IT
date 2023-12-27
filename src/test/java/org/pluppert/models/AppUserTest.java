package org.pluppert.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pluppert.enums.AppRole;

class AppUserTest {

    private AppUser appUser;
    private AppUser appAdmin;
    @BeforeEach
    void setUp() {
        appUser = new AppUser("User", "mJau125/", AppRole.ROLE_APP_USER);
        appAdmin = new AppUser("Admin", "mJau125/", AppRole.ROLE_APP_ADMIN);
    }

    @Test
    void getUsername() {
        String expectedUserName = "User";
        Assertions.assertEquals(expectedUserName, appUser.getUsername());
    }

    @Test
    void getRole() {
        Assertions.assertEquals(AppRole.ROLE_APP_USER, appUser.getRole());
    }

}
