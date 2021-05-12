package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<String, SoftReference<String>> loadedFiles = new HashMap<>();
    private final Path path;

    public Cache(Path path) {
        this.path = path;
    }

    public String searchInCache(String name) throws IOException {
        String strong = null;
        Path pathLoad = Path.of(String.format("%s%s%s", path.toString(), "/", name));
        try {
            if (loadedFiles.containsKey(name)) {
                strong = create(name, pathLoad);
                if (strong == null || strong.isEmpty()) {
                    loadToCache(pathLoad);
                    strong = loadedFiles.get(name).get();
                }
            } else {
                loadedFiles.put(name, new SoftReference<>(""));
                strong = searchInCache(name);
            }
        } catch (NullPointerException e) {
            strong = create(name, pathLoad);
        }
        return strong;
    }

    private String loadToCache(Path path) throws IOException {
        String s = path.toFile().getName();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
                StringBuilder sb = new StringBuilder();
                br.lines().forEach(sb :: append);
               return sb.toString();
        }
    }

    private String create(String name, Path pathLoad) throws IOException {
        String strong = loadToCache(pathLoad);
        SoftReference<String> soft = new SoftReference<>(strong);
        loadedFiles.put(name, soft);
        return strong;
    }

    public static void main(String[] args) throws IOException {
        Cache cache = new Cache(Path.of("C:/test/cache"));
        System.out.println(cache.searchInCache("Names.txt"));
        System.out.println(cache.searchInCache("Names.txt"));
        cache.loadedFiles.put("Names.txt", new SoftReference<>(null));
        System.out.println(cache.searchInCache("Names.txt"));
        cache.loadedFiles.put("Names.txt", null);
        System.out.println(cache.searchInCache("Names.txt"));
    }
}
