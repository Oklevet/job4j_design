package ru.job4j.tasks.obj;

public class Task15 {

    Object nested = new Object() {
        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "1";
        }
    };

}
