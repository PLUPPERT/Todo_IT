package org.pluppert.data;

import org.pluppert.data.impl.AppUserDAOCollection;
import org.pluppert.model.AppUser;
import org.pluppert.model.TodoItemTask;

public interface AppUserDAO extends BaseDAO<AppUser> {
    AppUserDAO INSTANCE = AppUserDAOCollection.getInstance();
    AppUser create(AppUser user);
    AppUser findByUsername(String username);
}
