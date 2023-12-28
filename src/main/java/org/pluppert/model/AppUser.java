package org.pluppert.model;

import org.pluppert.enums.AppRole;
import org.pluppert.utils.Utils;

import java.util.Objects;

public class AppUser {
    private String username;
    private String password;
    private AppRole role;
    Utils utils = new Utils();

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        if (utils.isNullOrEmpty(username)) throw new IllegalArgumentException("Username cannot be null or empty");
        this.username = username;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        if (utils.invalidPassword(password)) throw new IllegalArgumentException("Invalid password");
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    private void setRole(AppRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(username, appUser.username) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppUser {");
        sb.append("\n\tusername = '").append(username).append('\'');
        sb.append("\n\trole = ").append(role);
        sb.append("\n}");
        return sb.toString();
    }

}
