package org.pluppert;

import org.pluppert.data.AppUserDAO;
import org.pluppert.data.PersonDAO;
import org.pluppert.data.TodoItemDAO;
import org.pluppert.data.TodoItemTaskDAO;
import org.pluppert.enums.AppRole;
import org.pluppert.model.AppUser;
import org.pluppert.model.Person;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PersonDAO personInstance = PersonDAO.INSTANCE;
        AppUserDAO appUserInstance = AppUserDAO.INSTANCE;
        TodoItemDAO itemInstance = TodoItemDAO.INSTANCE;
        TodoItemTaskDAO taskInstance = TodoItemTaskDAO.INSTANCE;

        appUserInstance.persist(new AppUser("KattSkrället", "böLLeBö!12", AppRole.ROLE_APP_USER));
        appUserInstance.persist(new AppUser("ByRackan", "böLLeBö!13", AppRole.ROLE_APP_USER));
        appUserInstance.persist(new AppUser("RåttFan", "böLLeBö!14", AppRole.ROLE_APP_ADMIN));
        appUserInstance.persist(new AppUser("GubbFan", "böLLeBö!15", AppRole.ROLE_APP_ADMIN));
        personInstance.persist(new Person("Mjau", "Olsson", "mjau@mjau.crr", appUserInstance.findByUsername("KattFan")));
        personInstance.persist(new Person("Vov", "Vovsson", "vov@vov.grr", appUserInstance.findByUsername("HundFan")));
        personInstance.persist(new Person("Pip", "Pippolo", "rats@darn.it", appUserInstance.findByUsername("RåttFan")));
        personInstance.persist(new Person("Blö", "Gnällsson", "kränkt@äldre.herre", appUserInstance.findByUsername("GubbFan")));

        appUserInstance.writeDataToFile(appUserInstance.findAll());
        personInstance.writeDataToFile(personInstance.findAll());

        System.out.println(appUserInstance.fetchDataFromFile());
        System.out.println(personInstance.fetchDataFromFile());
    }
}
