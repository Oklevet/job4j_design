package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.nio.file.Path;

public class CacheEmulator {

    public static void main(String[] args) {
        Cache cache = new Cache(Path.of("C:/test/cache"));
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println("==============");
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println(cache.put("Names.txt", "qwe"));
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println("==============");
        System.out.println(cache.put("Names.txt", null));
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println("++++");
        System.out.println(cache.searchInCache("Names.txt"));
    }
}
