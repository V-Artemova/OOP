package com.company;

import java.io.PrintStream;
import java.util.Arrays;

public class Person {
    String name;
    Integer age;
    String position;

    public Person(String name, Integer age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    void print(Person person) {
        System.out.printf("%20s %2d %20s \n", person.name,
                person.age,
                person.position);
    }

    void sort_cells_age(Person person[]) {
        for (int i = 0; i < person.length; i++) {
            int j_max = i;
            for (int j = i + 1; j < person.length; j++) {
                if (person[j_max].age < person[j].age) {
                    j_max = j;
                }
            }

            Person temp = person[i];
            person[i] = person[j_max];
            person[j_max] = temp;

        }

    }

    void sort_cells_name(Person person[]) {
        Arrays.sort(person, (a, b) -> a.name.compareTo(b.name));

    }
    void sort_cells_position(Person person[]) {
        Arrays.sort(person, (a, b) -> a.position.compareTo(b.position));

    }


    public void printToFile(PrintStream stream, Person person) {
    stream.printf("%20s %2d %20s \n", person.name,
            person.age,
            person.position);
    }
}
