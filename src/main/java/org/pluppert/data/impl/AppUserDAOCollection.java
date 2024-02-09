package org.pluppert.data.impl;
import org.pluppert.data.AppUserDAO;
import org.pluppert.model.AppUser;

import java.util.Collection;

public class AppUserDAOCollection implements AppUserDAO {

    private static final AppUserDAO INSTANCE;

    static {
        INSTANCE = new AppUserDAOCollection();
    }



    public static AppUserDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public AppUser findByUsername(String username) {
        return findAll().stream()
                .filter(appUser -> appUser.getUsername().equals(username))
                .findAny().orElse(null);
    }

    @Override
    public AppUser create(AppUser appUser) {
        if (appUser == null) throw new NullPointerException("appUser is null");
        return appUser;
    }

    @Override
    public Collection<AppUser> findAll() {
        return null;
    }

}
