package org.pluppert;

public class Main {
    public static void main(String[] args) {

        IdGenerator idGenerator = new IdGenerator();

        Person person1 = new Person("Mjau", "Kattsson", "mjau_katts@gmjau.se", idGenerator);
        Person person2 = new Person("Woff", "Bäverman", "fisk@medben.se", idGenerator);
        Person person3 = new Person("Slingrid", "Snokus", "snoksupport@snok.sss", idGenerator);

        System.out.println(person1.getSummary());
        System.out.println(person2.getSummary());
        System.out.println(person3.getSummary());

        TodoItem item1 = new TodoItem("Bare Gört!", "Men schyssta, bare gört då! =(",null, person1, idGenerator);
        TodoItem item2 = new TodoItem("Hitt på nåt!", "Nu börjar jag bli lite sur...",null, person2, idGenerator);
        TodoItem item3 = new TodoItem("Det var droppen!", "Nej, nej, nej! Förlåååt...",null, person3, idGenerator);

        System.out.println(item1.getSummary());
        System.out.println(item2.getSummary());
        System.out.println(item3.getSummary());
    }
}