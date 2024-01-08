package org.pluppert.data;

import org.pluppert.model.AppUser;

public interface AppUserDAO extends BaseDAO<AppUser, String> {
    AppUserDAO INSTANCE = AppUserDAOCollection.getInstance();
    AppUser findByUsername(String username);
}
