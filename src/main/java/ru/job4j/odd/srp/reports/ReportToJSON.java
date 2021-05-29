package ru.job4j.odd.srp.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportToJSON {
    private Store store;

    public ReportToJSON(Store store) {
            this.store = store;
        }

    public String generate(Predicate<Employee> filter) {
        final Gson gson = new GsonBuilder().create();
        String s = gson.toJson(new ReportEngine(store));
        return s;
    }
}
