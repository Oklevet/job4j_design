package ru.job4j.tasks.obj;

public class Task6 {
    private int age = 20;
    private String name;
    private String surname;

    public Task6(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Task6() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
