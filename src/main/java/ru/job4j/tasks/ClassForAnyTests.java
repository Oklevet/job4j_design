package ru.job4j.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassForAnyTests {

    public static void main(String[] args) {
        ClassForAnyTests obj = new ClassForAnyTests();
        obj.call();


        AtomicInteger atomicInteger = new AtomicInteger(0);

        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger);

        atomicInteger.addAndGet(20);
        System.out.println(atomicInteger);

    }

    public void call() {

        ArrayList<Model> arr = new ArrayList<>();

        arr.add(new Model(1, new ArrayList<>()));
        arr.add(new Model(2, new ArrayList<>()));
        arr.add(new Model(3, new ArrayList<>()));
        arr.add(new Model(4, new ArrayList<>()));

        arr.forEach(x -> x.getList().add("qwe"));

        arr.forEach(x -> System.out.println(x.toString()));

    }

    static class Model {
        private int id;
        private List<String> list;

        public Model(int id, List<String> list) {
            this.id = id;
            this.list = list;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            list.forEach(stringBuilder::append);
            return "Model{"
                    + "id=" + id
                    + ", list=" + stringBuilder
                    + '}';
        }
    }
}
