package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<String, Set<FileProperty>> map = new HashMap<>();
    List<FileProperty> mapOfDuplicate = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String name = file.toFile().getName();
        Long size = file.toFile().length();
        FileProperty fileProperty = new FileProperty(size, name);
        if (map.containsKey(name)) {
            if (map.get(name).contains(fileProperty)) {
                mapOfDuplicate.add(fileProperty);
            } else {
                map.get(name).add(fileProperty);
            }
        } else {
            var arr = new HashSet<FileProperty>();
            arr.add(fileProperty);
            map.put(name, arr);
        }
        mapOfDuplicate.forEach(s -> s.toString());
        return super.visitFile(file, attrs);
    }
}
