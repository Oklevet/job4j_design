package ru.job4j.stream;

import java.util.*;

public class MinExampleMain {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparing(Person::getAge));
        int age = youngestPerson.get().getAge();
        System.out.println(age);

        Optional<Person> oldestPerson = people.stream()
                .max(Comparator.comparing(Person::getAge));
        age = oldestPerson.get().getAge();
        System.out.println(age);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        long sum = nums.stream()
                .filter(el -> el % 2 == 0)
                .count();
        System.out.println(sum);

        OptionalDouble average = people.stream()
                .mapToInt(Person::getAge)
                .average();
        double avg = average.getAsDouble();
        System.out.println(avg);

        sum = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sum);
    }
}
