package ru.job4j.gc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;


public class GCUsers {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        System.gc();
        info();
        User us1 = new User();
        User us2 = new User(2);
        User us3 = new User("qweasd");
        User us4 = new User(4, "qweqweasd");
        info();
        User us12 = new User(true);
        User us22 = new User("qwe", true);
        User us31 = new User(1, "qweasd", false);
        User us42 = new User(4, "qweqweasd", "qweqe", false);
        User us11 = new User("qweq", "asd");
        User us21 = new User("sdiugvbaevlfuivbefiuvbviuefabvuij", true);
        User us32 = new User("qweasd");
        User us41 = new User(4, "qweqweasd");
        byte aShort = 1;
        int aInt = 11;
        double aDoub = 2.1313D;
        String s = "qwe";
        info();
        System.out.println(sizeOf(us1));
        System.out.println(sizeOf(us2));
        System.out.println(sizeOf(us3));
        System.out.println(sizeOf(us4));
        System.out.println(sizeOf(us12));
        System.out.println(sizeOf(us22));
        System.out.println(sizeOf(us31));
        System.out.println(sizeOf(us42));
        System.out.println(sizeOf(us11));
        System.out.println(sizeOf(us21));
        System.out.println(sizeOf(aShort));
        System.out.println(sizeOf(aInt));
        System.out.println(sizeOf(aDoub));
        System.out.println(sizeOf(s));
        info();
        for (int i = 0; i < 10; i++) {
            new User(i, "N" + i);
        }
        info();
    }
}
