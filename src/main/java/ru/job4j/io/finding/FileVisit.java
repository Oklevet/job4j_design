package ru.job4j.io.finding;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Predicate;

public class FileVisit extends SimpleFileVisitor<Path> {
    private final Predicate<Path> predicate;
    private final FindFiles findFiles;

    public FileVisit(Predicate<Path> predicate, FindFiles findFiles) {
        this.predicate = predicate;
        this.findFiles = findFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
       if (predicate.test(file)) {
            String s = file.toFile().getName();
            findFiles.getResult().add(s);
        }
        return super.visitFile(file, attrs);
    }
}
