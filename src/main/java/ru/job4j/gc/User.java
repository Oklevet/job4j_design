package ru.job4j.gc;

public class User {
    private int age;
    private String name;
    private String name2;
    private boolean flag;

    public User() {
    }

    public User(String qwe, boolean flag) {
        this.flag = flag;
    }

    public User(int age) {
        this.age = age;
    }

    public User(int age, String name, String name2, boolean flag) {
        this.age = age;
        this.name = name;
        this.name2 = name2;
        this.flag = flag;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User(boolean flag) {
        this.flag = flag;
    }

    public User(int age, String name2, boolean flag) {
        this.age = age;
        this.name2 = name2;
        this.flag = flag;
    }

    public User(String name, String name2) {
        this.name = name;
        this.name2 = name2;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
