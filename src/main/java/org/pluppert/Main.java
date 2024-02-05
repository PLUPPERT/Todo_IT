package org.pluppert;

import org.pluppert.data.PersonDAO;
import org.pluppert.model.Person;

public class Main {
    public static void main(String[] args) {
        PersonDAO personInstance = PersonDAO.INSTANCE;
        /*
        personInstance.create(new Person("Mjau", "Olsson"));
        personInstance.create(new Person("Vov", "Vovsson"));
        personInstance.create(new Person("Pip", "Pippolo"));
        personInstance.create(new Person("Blö", "Gnällsson"));
        */

        /*
        personInstance.findAll().forEach(System.out::println);

        System.out.println("\n---------------------------------------------\n");

        personInstance.create(new Person("Waria", "Peacedottir"));

        System.out.println("\n---------------------------------------------\n");
        */

//        personInstance.create(new Person("Blogg", "Influencia"));

        personInstance.findAll().forEach(System.out::println);

        System.out.println("\n---------------------------------------------\n");

        System.out.println("findById(?) = " + personInstance.findById(6));

        System.out.println("\n---------------------------------------------\n");

        System.out.println("findByName: ");
        personInstance.findByName("sson").forEach(System.out::println);

    }
}
