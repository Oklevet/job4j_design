package ru.job4j.odd.lsp.foodstorage;

import java.time.LocalDate;
import java.time.Period;

public class ControllQuality {
    private short discount;

    void locateFood(Food food) {
        double coeffDelay = Double.parseDouble(String.valueOf(Period.between(LocalDate.now(), food.createDate).getDays()))
                / Double.parseDouble(String.valueOf(Period.between(food.createDate, food.expiryDate).getDays()));

        if (coeffDelay < 0.25) {
            new Warehouse().addFood(food);
        } else if (coeffDelay >= 0.25 && coeffDelay < 0.75) {
            new Shop().addFood(food);
        } else if (coeffDelay >= 0.75 && coeffDelay <= 1) {
            food.setDiscount(discount);
            new Shop().addFood(food);
        } else {
            new Trash().addFood(food);
        }
    }
}
