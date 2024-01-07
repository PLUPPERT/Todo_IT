package org.pluppert.data;

import org.pluppert.model.AppUser;

public interface AppUserDAO extends BaseDAO<AppUser, String> {
    AppUser findByUsername(String username);
}
