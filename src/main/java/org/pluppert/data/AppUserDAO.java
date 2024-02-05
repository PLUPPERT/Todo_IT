package org.pluppert.data;

import org.pluppert.data.impl.AppUserDAOCollection;
import org.pluppert.model.AppUser;

public interface AppUserDAO extends BaseDAO<AppUser> {
    AppUserDAO INSTANCE = AppUserDAOCollection.getInstance();
    AppUser findByUsername(String username);
}
