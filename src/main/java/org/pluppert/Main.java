package org.pluppert;

import org.pluppert.data.PersonDAO;
import org.pluppert.model.Person;

public class Main {
    public static void main(String[] args) {
        PersonDAO personInstance = PersonDAO.INSTANCE;
        Person person1 = new Person("Kalle", "Korv");
        personInstance.create(person1);
    }
}
