package org.pluppert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.pluppert.data.AppUserDAO;
import org.pluppert.data.PersonDAO;
import org.pluppert.enums.AppRole;
import org.pluppert.model.AppUser;
import org.pluppert.model.Person;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello nerd.");
        PersonDAO personInstance = PersonDAO.INSTANCE;
        AppUserDAO appUserInstance = AppUserDAO.INSTANCE;

        String pathToPersonJson = "src/main/resources/protocols/person.json";
        String pathToUserJson = "src/main/resources/protocols/app_user.json";
        String pathToItemJson = "src/main/resources/protocols/todo_item.json";
        String pathToTaskJson = "src/main/resources/protocols/todo_item_task.json";
        Writer writerPerson = new FileWriter(pathToPersonJson);
        Writer writerUser = new FileWriter(pathToUserJson);
        Writer writerItem = new FileWriter(pathToItemJson);
        Writer writerTask = new FileWriter(pathToTaskJson);
        Gson gsonPerson = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonUser = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonItem = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonTask = new GsonBuilder().setPrettyPrinting().create();

        appUserInstance.persist(new AppUser("KattFan", "böLLeBö!12", AppRole.ROLE_APP_USER));
        appUserInstance.persist(new AppUser("HundFan", "böLLeBö!13", AppRole.ROLE_APP_USER));
        appUserInstance.persist(new AppUser("RåttFan", "böLLeBö!14", AppRole.ROLE_APP_ADMIN));
        appUserInstance.persist(new AppUser("GubbFan", "böLLeBö!15", AppRole.ROLE_APP_ADMIN));
        personInstance.persist(new Person("Mjau", "Olsson", "mjau@mjau.crr", appUserInstance.findByUsername("KattFan")));
        personInstance.persist(new Person("Vov", "Vovsson", "vov@vov.grr", appUserInstance.findByUsername("HundFan")));
        personInstance.persist(new Person("Pip", "Pippolo", "rats@darn.it", appUserInstance.findByUsername("RåttFan")));
        personInstance.persist(new Person("Blö", "Gnällsson", "kränkt@äldre.herre", appUserInstance.findByUsername("GubbFan")));

        gsonUser.toJson(appUserInstance.findAll(), writerUser);
        writerUser.close();
        gsonPerson.toJson(personInstance.findAll(), writerPerson);
        writerPerson.close();

        try (Reader readerUser = new FileReader(pathToUserJson)) {
            List<AppUser> deserializedUserList = gsonUser.fromJson(readerUser, (List.class));

//            deserializedUserList.forEach(System.out::println);
            System.out.println(deserializedUserList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader readerPerson = new FileReader(pathToPersonJson)) {
            List<Person> deserializedPersonList = gsonPerson.fromJson(readerPerson, List.class);

//            deserializedPersonList.forEach(System.out::println);
            System.out.println(deserializedPersonList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}