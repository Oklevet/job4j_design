package ru.job4j.collection.queue;

public record Task(Position position,
                   String description,
                   int urgency) {
}