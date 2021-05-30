package ru.job4j.odd.lsp.foodstorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
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
        if (new Warehouse().checkContain(food)) {
            warehouse.add(food);
        }
    }

    public boolean checkContain(Food food) {
        return warehouse.contains(food);
    }

    public void deleteFood(Food food) {
        warehouse.remove(food);
    }
}
