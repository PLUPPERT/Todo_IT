package org.pluppert;

import org.pluppert.enums.AppRole;
import org.pluppert.models.AppUser;
import org.pluppert.models.Person;
import org.pluppert.models.TodoItem;
import org.pluppert.models.TodoItemTask;
import org.pluppert.sequencer.IdGenerator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        IdGenerator idGenerator = new IdGenerator();

//        Person person1 = new Person("Mjau", "Kattsson", "mjau_katts@gmjau.se", idGenerator);
//        Person person2 = new Person("Woff", "Bäverman", "fisk@medben.se", idGenerator);
//        Person person3 = new Person("Slingrid", "Snokus", "snoksupport@snok.sss", idGenerator);
        /*
        System.out.println(person1.getSummary());
        System.out.println(person2.getSummary());
        System.out.println(person3.getSummary());
        */
//        TodoItem item1 = new TodoItem(
//                "Bare Gört!",
//                "Men schyssta, bare gört då! =(",
//                null,
//                person1,
//                idGenerator);
//        TodoItem item2 = new TodoItem(
//                "Hitt på nåt!",
//                "Nu börjar jag bli lite sur...",
//                null,
//                person2,
//                idGenerator);
//        TodoItem item3 = new TodoItem(
//                "Starta en hamsterklubb",
//                "Skapa en klubb för alla som älskar att skryta om sin hamster",
//                LocalDate.parse("2028-03-29"),
//                person3,
//                idGenerator);
        /*
        System.out.println(item1.getSummary());
        System.out.println(item2.getSummary());
        */
//        System.out.println(item3.getSummary());
//
//        TodoItemTask task1 = new TodoItemTask(item1, person1, idGenerator);
//        TodoItemTask task2 = new TodoItemTask(item2, null, idGenerator);
//        TodoItemTask task3 = new TodoItemTask(item3, person3, idGenerator);
//
//        System.out.println(task1.getSummary());
//        System.out.println(task2.getSummary());
//        System.out.println(task3.getSummary());
        String test = "åäZöö Å123-";
        System.out.println("test = " + test);

        AppUser appUser = new AppUser("MjauPelle", test, AppRole.ROLE_APP_USER);

        System.out.println(appUser);
    }
}