package ru.job4j.collection.map;

/**
 * Объект хранящий в себе два параметра наименование предмета/ученика и балла
 * @author NIK STARTSEV
 * @version 1.0
 */
public class Label implements Comparable<Label> {
    /**
     * STRING - наименование объекта,
     * DOUBLE - балл по объекту
     */
    private String name;
    private double score;

    @Override
    public int compareTo(Label o) {
        return 0;
    }

    public Label(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
