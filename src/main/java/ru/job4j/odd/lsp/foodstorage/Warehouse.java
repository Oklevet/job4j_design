package ru.job4j.odd.lsp.foodstorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Storage {
    List<Food> warehouse = new ArrayList<>();
    private final double quat = 0.25D;
    double presentExpir;
    double fullExpir;
    double coeffDelay;

    public boolean accept(Food food) {
        presentExpir = Double.parseDouble(String.valueOf(Period.between(LocalDate.now(),
                food.createDate).getDays()));
        fullExpir = Double.parseDouble(String.valueOf(Period.between(food.createDate,
                food.expiryDate).getDays()));
        coeffDelay = presentExpir / fullExpir;
        return coeffDelay < quat;
    }

    public void addFood(Food food) {
        warehouse.add(food);
    }

    @Override
    public List<Food> getListFood() {
        return warehouse;
    }

    @Override
    public void clearStorage() {
        warehouse.clear();
    }
}
