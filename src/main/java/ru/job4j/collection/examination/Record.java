package ru.job4j.collection.examination;

import java.util.HashSet;
import java.util.Set;

/**
 * Объект хранящий в себе два параметра о каждом пользователе
 * Один Record - одна запись из документа
 * @author NIK STARTSEV
 * @version 1.0
 */
public class Record {
    /**
     * STRING - имя пользователя,
     * SET<STRING> - множество его почтовых ящиков
     */
    private String name;
    private Set<String> set = new HashSet<String>();

    public Record(String name, Set<String> set) {
        this.name = name;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
}
