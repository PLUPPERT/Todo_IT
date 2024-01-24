package org.pluppert;

import org.pluppert.data.PersonDAO;
import org.pluppert.model.Person;

public class Main {
    public static void main(String[] args) {
        PersonDAO personInstance = PersonDAO.INSTANCE;
        /*personInstance.create(new Person("Mjau", "Olsson"));
        personInstance.create(new Person("Vov", "Vovsson"));
        personInstance.create(new Person("Pip", "Pippolo"));
        personInstance.create(new Person("Blö", "Gnällsson"));*/

        personInstance.findAll().forEach(System.out::println);

        System.out.println("\n---------------------------------------------\n");

        Person person1 = personInstance.findById(2);
        System.out.println("person1 = " + person1);

    }
}
