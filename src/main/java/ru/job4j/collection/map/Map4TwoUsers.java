package ru.job4j.collection.map;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Map4TwoUsers {
    public static void main(String[] args) {
        User user1 = new User("qweqwe", 1, new GregorianCalendar(2000, 10, 01));
        User user2 = new User("asdasd asd", 0, new GregorianCalendar(2004, 02, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        map.entrySet().forEach(a -> System.out.println(a.getKey().toString()));
        map.entrySet().forEach(a -> System.out.println(a.getKey().hashCode()));
    }
}
