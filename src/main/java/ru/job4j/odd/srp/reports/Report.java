package ru.job4j.odd.srp.reports;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
