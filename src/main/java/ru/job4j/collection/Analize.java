package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> map = new HashMap<>();
        int changed = 0;
        int notModify = 0;
        int sizeOfMap;
        User user;

        for (User u : previous) {
            map.put(u.id, u);
        }
        sizeOfMap = map.size();
        for (User u : current) {
            user = map.remove(u.id);
            if (user != null) {
                if (!(user.name.equals(u.name)) && user.id == u.id) {
                    changed++;
                } else if (user.name.equals(u.name) && user.id == u.id) {
                    notModify++;
                }
            }
        }
        System.out.println(notModify);
        System.out.println(map.size());
        System.out.println(changed);
        int deleted = sizeOfMap - changed - notModify;
        int added = current.size() - changed - notModify;
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 31 * 17 + Objects.hash(id, name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(id, user.id)
                    && Objects.equals(name, user.name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public Info(Info diff) {
            this.added = diff.added;
            this.changed = diff.changed;
            this.deleted = diff.deleted;
        }

        @Override
        public String toString() {
            return "Info {"
                + "added = "        + added
                + ", changed = '"   + changed
                + ", deleted = '"   + deleted + '\''
                + '}';
        }
    }
}
