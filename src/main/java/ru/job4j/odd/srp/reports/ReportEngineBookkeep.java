package ru.job4j.odd.srp.reports;

import java.util.function.Predicate;

public class ReportEngineBookkeep implements Report {
    private Store store;

    public ReportEngineBookkeep(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
            .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 76).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
