package ru.job4j.odd.lsp.foodstorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Shop extends Storage {
    List<Food> shop = new ArrayList<>();
    private final double quat   = 0.25D;
    private final double toQuat = 0.75D;
    private final double full     = 1D;
    short disc = 10;
    double presentExpir;
    double fullExpir;
    double coeffDelay;

    public boolean accept(Food food) {
        presentExpir = Double.parseDouble(String.valueOf(Period.between(LocalDate.now(),
                food.createDate).getDays()));
        fullExpir = Double.parseDouble(String.valueOf(Period.between(food.createDate,
                food.expiryDate).getDays()));
        coeffDelay = presentExpir / fullExpir;
        return (coeffDelay < full && coeffDelay >= quat);
    }

    public void addFood(Food food) {
        if (coeffDelay > toQuat) {
            food.discount = disc;

            shop.add(food);
        }
    }

    @Override
    public List<Food> getListFood() {
        return shop;
    }

    @Override
    public void clearStorage() {
        shop.clear();
    }
}
