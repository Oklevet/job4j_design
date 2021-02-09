package ru.job4j.generic;

import java.util.Date;

public class Person {
    private String name;
    private int age;
    private Date birthday;

    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() + "{"
                + "name='" + getName() + '\''
                + "age='" + getAge() + '\''
                + "birthday='" + getBirthday() + '\''
                + '}';
    }
}
