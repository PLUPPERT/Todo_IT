package org.pluppert.repositories;

import org.pluppert.enums.AppRole;
import org.pluppert.models.AppUser;
import org.pluppert.models.Person;
import org.pluppert.sequencer.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class PersonRepo {
    private static final IdGenerator idGenerator = new IdGenerator();
    private final ArrayList<Person> people = new ArrayList<>();

    public PersonRepo() {
        AppUser user1 = new AppUser("user1", "1djvfhgdQQ36?", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("user2", "2djvfhgdQQ36?", AppRole.ROLE_APP_USER);
        AppUser user3 = new AppUser("user3", "3djvfhgdQQ36?", AppRole.ROLE_APP_ADMIN);

        people.add(new Person("Mjau", "Kattsson", "mjau_katts@gmjau.se", user1, idGenerator));
        people.add(new Person("Woff", "Bäverman", "fisk@medben.se", user2, idGenerator));
        people.add(new Person("Slingrid", "Snokus", "snoksupport@snok.sss", user3, idGenerator));
    }
    public List<Person> getPeople() {
        return people;
    }
    public void addPersonToRepo(Person person) {
        people.add(person);
    }

    public Person getPersonById(int id) {
        for(Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}
