package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        Optional<Integer> sum = nums.stream()
                .reduce(Integer::sum);
        System.out.println(sum.get());


        List<String> strs = List.of("Один", "Два", "Три");
        Optional<String> str = strs.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(str.get());

        int sumInt = nums.stream()
                .reduce(2, Integer::sum);
        System.out.println(sumInt);

        int ssum = people.stream()
                .reduce(
                        0,
                        (a, b) -> {
                            if (b.getAge() > 25) {
                                return a + b.getAge();
                            } else {
                                return a;
                            }
                        },
                        Integer::sum
                );
        System.out.println(ssum);
    }
}
