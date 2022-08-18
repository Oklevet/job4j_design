package ru.job4j.tasks;

import java.util.Comparator;
import java.util.Objects;

public class SortThenComparingMethod {

    public static class User implements Comparable<User> {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
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
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(User o) {
            return name.compareTo(o.name);
        }

        public int compareToAge(User o) {
            return o.getAge() - age;
        }
    }

    public static Comparator<User> thenComparing() {
        return ascByName().thenComparing(descByAge());
    }

    public static Comparator<User> ascByName() {
        return User::compareTo;
    }

    public static Comparator<User> descByAge() {
        return User::compareToAge;
    }

    /**
     * another variant by sub class
      */
 /*
    public static int ascByName(User o1, User o2) {
         return o1.getName().compareTo(o2.getName());
    }

    public static int descByAge(User o1, User o2) {
         return o2.getAge() - o1.getAge();
    }

  public static class ThenComparing implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            int res = ascByName(o1, o2);
            if (res == 0) {
                return descByAge(o1, o2);
            }
            return res;
        }
    }
*/
}
