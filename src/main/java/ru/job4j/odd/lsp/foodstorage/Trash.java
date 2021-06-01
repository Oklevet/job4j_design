package ru.job4j.odd.lsp.foodstorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Trash extends Storage {
    List<Food> trash = new ArrayList<>();
    private final double full     = 1D;
    double presentExpir;
    double fullExpir;
    double coeffDelay;

    public boolean accept(Food food) {
        presentExpir = Double.parseDouble(String.valueOf(Period.between(LocalDate.now(),
                food.createDate).getDays()));
        fullExpir = Double.parseDouble(String.valueOf(Period.between(food.createDate,
                food.expiryDate).getDays()));
        coeffDelay = presentExpir / fullExpir;
        return coeffDelay >= full;
    }

    public void addFood(Food food) {
        trash.add(food);
    }

    @Override
    public List<Food> getListFood() {
        return trash;
    }

    @Override
    public void clearStorage() {
        trash.clear();
    }
}
