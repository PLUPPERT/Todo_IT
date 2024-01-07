package org.pluppert.data;

import org.pluppert.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserImpl implements AppUserDAO {

    private static final AppUserDAO INSTANCE;

    static {
        INSTANCE = new AppUserImpl();
    }

    private final List<AppUser> appUserList;

    private AppUserImpl() {
        appUserList = new ArrayList<>();
    }

    static AppUserDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserList.stream()
                .filter(appUser -> appUser.getUsername().equals(username))
                .findAny().orElse(null);
    }

    @Override
    public Object persist(Object value) {
        if ((value == null) || (value.getClass() == AppUser.class)) throw new NullPointerException("value is null or wrong object type");
        appUserList.add((AppUser) value);
        return value;
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUserList;
    }

    @Override
    public void remove(Object value) {

    }
}
