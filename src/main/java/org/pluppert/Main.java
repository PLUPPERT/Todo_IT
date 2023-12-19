package org.pluppert;

import org.pluppert.enums.AppRole;
import org.pluppert.models.AppUser;
import org.pluppert.models.Person;
import org.pluppert.models.TodoItem;
import org.pluppert.models.TodoItemTask;
import org.pluppert.repositories.PersonRepo;
import org.pluppert.sequencer.IdGenerator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        IdGenerator idGenerator = new IdGenerator();
        PersonRepo personRepo = new PersonRepo();

        personRepo.addPersonToRepo(
                new Person(
                        "Newbie",
                        "Newton",
                        "newnew@newmail.com",
                        new AppUser("NewNewMon", "nEwPoKeBoY2000!", AppRole.ROLE_APP_ADMIN),
                        idGenerator));

        for (Person person : personRepo.getPeople()) {
            System.out.println(person);
        }

        try {
            personRepo.getPersonById(3).updatePersonData("Apa", null, "", personRepo.getPersonById(2));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(personRepo.getPersonById(2));

        TodoItem item1 = new TodoItem(
                "Bare Gört!",
                "Men schyssta, bare gört då! =(",
                null,
                personRepo.getPersonById(1),
                idGenerator);
        TodoItem item2 = new TodoItem(
                "Hitt på nåt!",
                "Nu börjar jag bli lite sur...",
                null,
                personRepo.getPersonById(2),
                idGenerator);
        TodoItem item3 = new TodoItem(
                "Starta en hamsterklubb",
                "Skapa en klubb för alla som älskar att skryta om sin hamster",
                LocalDate.parse("2028-03-29"),
                personRepo.getPersonById(3),
                idGenerator);

        TodoItemTask task1 = new TodoItemTask(item1, personRepo.getPersonById(1), idGenerator);
        TodoItemTask task2 = new TodoItemTask(item2, null, idGenerator);
        TodoItemTask task3 = new TodoItemTask(item3, personRepo.getPersonById(3), idGenerator);

        AppUser appUser = new AppUser("MjauPelle", "Test123_", AppRole.ROLE_APP_USER);


    }
}