package ru.job4j.collection.examination.ver3;

import java.util.HashSet;
import java.util.Set;

public class RecordVer3 {
    /**
     * STRING - имя пользователя,
     * SET<STRING> - множество его почтовых ящиков
     */
    private String name;
    private Set<String> set = new HashSet<String>();

    public RecordVer3(String name, Set<String> set) {
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


