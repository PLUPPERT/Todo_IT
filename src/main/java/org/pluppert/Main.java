package org.pluppert;

import org.pluppert.data.PersonDAO;
import org.pluppert.data.TodoItemDAO;
import org.pluppert.model.Person;
import org.pluppert.model.TodoItem;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PersonDAO personInstance = PersonDAO.INSTANCE;
        TodoItemDAO itemInstance = TodoItemDAO.INSTANCE;
        String dottedLine = "\n---------------------------------------------\n";
/*
        System.out.println("Create a TodoItems:");

        itemInstance.createItem(new TodoItem(
                "Saken_1",
                "Gör saken 1.",
                LocalDateTime.now().plusDays(5),
                personInstance.findById(4)
        ));

        itemInstance.createItem(new TodoItem(
                "Saken_2",
                "Gör saken 2.",
                personInstance.findById(4)
        ));

        itemInstance.createItem(new TodoItem(
                "Saken_3",
                "Gör saken 3.",
                personInstance.findById(4)
        ));
        itemInstance.createItem(new TodoItem(
                "Saken_4",
                "Gör saken 4.",
                LocalDateTime.now().plusDays(5),
                personInstance.findById(2),
                personInstance.findById(4)
        ));*/

        System.out.println(dottedLine);

        itemInstance.findByTitleContains("e_").forEach(System.out::println);

        System.out.println(dottedLine);
    }
}
