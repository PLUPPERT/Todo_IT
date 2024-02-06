package org.pluppert;

import org.pluppert.data.PersonDAO;
import org.pluppert.model.Person;

public class Main {
    public static void main(String[] args) {
        PersonDAO personInstance = PersonDAO.INSTANCE;
        String dottedLine = "\n---------------------------------------------\n";
        /*
        personInstance.create(new Person("Mjau", "Olsson"));
        personInstance.create(new Person("Vov", "Vovsson"));
        personInstance.create(new Person("Pip", "Pippolo"));
        personInstance.create(new Person("Blö", "Gnällsson"));
        */

        /*
        personInstance.findAll().forEach(System.out::println);

        System.out.println(dottedLine);

        personInstance.create(new Person("Waria", "Peacedottir"));

        System.out.println(dottedLine);
        */

//        personInstance.create(new Person("Blogg", "Influencia"));

        personInstance.findAll().forEach(System.out::println);

        System.out.println(dottedLine);

        System.out.println("findById(?) = " + personInstance.findById(6));

        System.out.println(dottedLine);

        System.out.println("findByName: ");
        personInstance.findByName("ls").forEach(System.out::println);

        System.out.println(dottedLine);

        System.out.println("(Person) update:");
        System.out.println("   Before update:");
        System.out.println("   " + personInstance.findById(2));
        System.out.println("   After update:");
        System.out.println("   " + personInstance.update(new Person(2, "Kisse", "Spinnaker")));
    }
}
