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
        value = loadedFiles.getOrDefault(name, new SoftReference<>("")).get();
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

    public String put(String name, String value) {
        if (value == null) {
            return "Error of loading cache. Value cant be null.";
        }
        loadedFiles.put(name, new SoftReference<>(value));
        return "Data cached.";
    }
}