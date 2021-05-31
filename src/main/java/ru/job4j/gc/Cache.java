package ru.job4j.gc;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<String, SoftReference<String>> loadedFiles = new HashMap<>();
    private final Path path;

    public Cache(Path path) {
        this.path = path;
    }

    public String searchInCache(String name) {
        Path pathLoad = Path.of(String.format("%s%s%s", path.toString(), "/", name));
        String value = "";
        try {
                value = loadedFiles.getOrDefault(name, new SoftReference<>("")).get();
            } catch (NullPointerException e) {
        }
        //value = loadedFiles.getOrDefault(name, new SoftReference<>("")).get();
        if (value == null || value.isEmpty()) {
            try {
                return create(name, pathLoad);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
    private String create(String name, Path path) throws IOException {
        String data = loadToCache(path);
        loadedFiles.put(name, new SoftReference<>(data));
        return data;
    }

    private String loadToCache(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error of loading cache.";
    }

    public static void main(String[] args) throws IOException {
        Cache cache = new Cache(Path.of("C:/test/cache"));
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println("==============");
        System.out.println(cache.searchInCache("Names.txt"));
        cache.loadedFiles.put("Names.txt", new SoftReference<>(null));
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println("==============");
        cache.loadedFiles.put("Names.txt", null);
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println("++++");
        System.out.println(cache.searchInCache("Names.txt"));
    }
}
