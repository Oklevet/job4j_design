package ru.job4j.collection.map;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Объект хранящий в себе два параметра о каждом школьном предмете
 * @author NIK STARTSEV
 * @version 1.0
 */
public class Subject {
    /**
     * STRING - наименование предмета,
     * INT - атестационный балл по предмету
     */
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}