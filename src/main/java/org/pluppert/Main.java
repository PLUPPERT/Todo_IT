package org.pluppert;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Mjau", "Kattsson", "mjau_katts@gmailur.se");

        System.out.println(person1.getSummary());

        TodoItem item1 = new TodoItem("Bare Gört!", null,null, person1);

        System.out.println(item1.getSummary());
    }
}