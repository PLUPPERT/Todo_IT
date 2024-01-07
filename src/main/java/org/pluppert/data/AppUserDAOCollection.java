package org.pluppert.data;

import org.pluppert.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDAOCollection implements AppUserDAO {

    private static final AppUserDAO INSTANCE;

    static {
        INSTANCE = new AppUserDAOCollection();
    }

    private final List<AppUser> appUserList;

    private AppUserDAOCollection() {
        appUserList = new ArrayList<>();
    }

    static AppUserDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public AppUser findByUsername(String username) {
        return findAll().stream()
                .filter(appUser -> appUser.getUsername().equals(username))
                .findAny().orElse(null);
    }

    @Override
    public AppUser persist(AppUser appUser) {
        if (appUser == null) throw new NullPointerException("appUser is null");
        appUserList.add(appUser);
        return appUser;
    }

    @Override
    public Collection<AppUser> findAll() {
        return List.copyOf(appUserList);
    }

    @Override
    public void remove(String username) {
        appUserList.remove(findByUsername(username));
    }
}
