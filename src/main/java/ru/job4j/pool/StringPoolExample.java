package ru.job4j.pool;

public class StringPoolExample {
    public static void main(String[] args) {
        String string1 = new String("Hello");
        String string2 = new String("Hello");
        String string3 = "Hello";
        String string4 = "Hello";
        System.out.println(string1 == string2);
        System.out.println(string3 == string4);
        System.out.println(string1 == string3);
        System.out.println(string2 == string4);

        String string11 = "Hello, world";
        String string22 = "Hello, " + "world";
        System.out.println(string11 == string22);

        String string111 = "Hello, world";
        String string222 = "Hello, ";
        String string333 = string222 + "world";
        System.out.println(string111 == string333);

        String string10 = "Hello";
        String string20 = new String("Hello");
        String string30 = string20.intern();
        System.out.println(string10 == string30);

        System.out.println(new String("New string") == new String("New string"));
        System.out.println(new String("Interned string").intern() == new String("Interned string").intern());
    }
}