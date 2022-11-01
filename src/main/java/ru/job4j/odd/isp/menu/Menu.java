package ru.job4j.odd.isp.menu;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    Map<String, Item> map = new TreeMap<>();
    Map<String, Integer> mapCount = new TreeMap<>();
    int countRoot = 1;
    String task = "Задача ";
    String spot = ".";

    public void addRoot(Item item) {
        map.put(task + countRoot + spot, item);
        mapCount.putIfAbsent(task + countRoot + spot, 0);
        mapCount.put(task + countRoot + spot, mapCount.get(task + countRoot + spot) + 1);
        countRoot++;
    }

    public void addSub(String name, Item item) {
        if (!mapCount.containsKey(name)) {
            System.out.println("Wrong name of task. Please reenter.");
            return;
        }
        int countSub = mapCount.get(name);
        map.put(name + countSub + spot, item);
        mapCount.putIfAbsent(name + countSub + spot, 0);
        mapCount.put(name + countSub + spot, mapCount.get(name + countSub + spot) + 1);
        mapCount.put(name, mapCount.get(name) + 1);
    }

    public void showMenu() {
        for (Map.Entry<String, Item> rec : map.entrySet()) {
            Matcher matcher = Pattern.compile("\\b.").matcher(rec.getKey());
            StringBuilder strTabs = new StringBuilder();
            int countTab = -3;
            while (matcher.find()) {
                if (countTab > 0) {
                    strTabs.append("--");
                } else {
                    countTab++;
                }
            }
            System.out.print(strTabs);
            System.out.println(rec.getKey());
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addRoot(new Item("qwe", new Operation2()));
        menu.addSub("Задача 1.", new Item("qwe1", new Operation1()));
        menu.addSub("Задача 1.", new Item("qwe2", new Operation1()));
        menu.addSub("Задача 1.2.", new Item("qwe2asd", new Operation2()));
        menu.addRoot(new Item("zxc", new Operation1()));
        menu.showMenu();
    }
}
