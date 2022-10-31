package ru.job4j.collection.map;

import java.util.List;

/**
 * Объект хранящий в себе два параметра о каждом ученике. Имя и список предметов.
 * @author NIK STARTSEV
 * @version 1.0
 */
public class Pupil {
    /**
     * STRING - имя ученеика,
     * List<Subject> - список предметов ученика
     */
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
