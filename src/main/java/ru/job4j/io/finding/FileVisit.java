package ru.job4j.io.finding;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileVisit extends SimpleFileVisitor<Path> {
    private final Predicate<Path> predicate;
    private List<Path> list = new ArrayList<>();

    public FileVisit(Predicate<Path> predicate, String findFiles) {
        this.predicate = predicate;
    }

    public List<Path> getList() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            list.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
