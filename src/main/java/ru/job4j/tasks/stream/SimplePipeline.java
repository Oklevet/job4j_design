package ru.job4j.tasks.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimplePipeline {
    private final List<Integer> data;

    private final List<Pipe<Integer>> pipes = new ArrayList<>();

    private SimplePipeline(List<Integer> source) {
        data = source;
    }

    public static SimplePipeline of(Integer... source) {
        return new SimplePipeline(List.of(source));
    }

    public SimplePipeline map(Function<Integer, Integer> fun) {
        pipes.add(new MapPipe<>(fun));
        return this;
    }

    public SimplePipeline filter(Predicate<Integer> fun) {
        pipes.add(new FilterPipe<>(fun));
        return this;
    }

    public List<Integer> collect() {
        var accumulate = new ArrayList<Integer>();
        boolean isGet;
        Integer lastVal = null;

        for (var value: data) {
            isGet = true;
            lastVal = value;
            for (var pipe : pipes) {
                if (pipe.getClass() == FilterPipe.class) {
                    if (!pipe.state(lastVal).pass()) {
                        isGet = false;
                    }
                }
                if (pipe.getClass() == MapPipe.class) {
                    lastVal = (Integer) pipe.state(lastVal).get();
                }
            }
            System.out.println();
            if (isGet) {
                accumulate.add(lastVal);
            }
        }
        return accumulate;
    }

    public interface Pipe<T> {
        <R> State<R> state(T value);
    }


    public static class MapPipe<T> implements Pipe<T> {
        private final Function<T, T> function;

        public MapPipe(Function<T, T> function) {
            this.function = function;
        }

        @Override
        public <R> State<R> state(T value) {
            return () -> (R) function.apply(value);
        }
    }

    public static class FilterPipe<T> implements Pipe<T> {
        private final Predicate<T> filter;

        public FilterPipe(Predicate<T> filter) {
            this.filter = filter;
        }

        @Override
        public <R> State<R> state(T value) {
            return new State<R>() {
                @Override
                public boolean pass() {
                    return filter.test(value);
                }

                @Override
                public R get() {
                    return (R) value;
                }
            };
        }
    }

    public interface State<T> {

        default boolean pass() {
            return true;
        }

        T get();
    }

    public static void main(String[] args) {
        SimplePipeline.of(1, 2, 3, 4)
                .filter(el -> el > 1)
                .map(el -> el * el)
                .filter(el -> el > 10)
                .collect()
                .forEach(System.out::println);
    }
}