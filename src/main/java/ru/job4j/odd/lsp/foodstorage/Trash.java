package ru.job4j.odd.lsp.foodstorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Trash {
    List<Food> trash = new ArrayList<>();
    private final double toQuat   = 0.75D;
    private final double full     = 1D;
    double presentExpir;
    double fullExpir;
    double coeffDelay;
    double yesterCoeff;

    public boolean accept(Food food) {
        presentExpir = Double.parseDouble(String.valueOf(Period.between(LocalDate.now(),
                food.createDate).getDays()));
        fullExpir = Double.parseDouble(String.valueOf(Period.between(food.createDate,
                food.expiryDate).getDays()));
        coeffDelay = presentExpir / fullExpir;
        return (coeffDelay <= full && coeffDelay >= toQuat);
    }

    public void addFood(Food food) {
        if (!new Trash().checkContain(food)) {
            trash.add(food);
        }
        new Trash().checkYesterday(food);
    }

    public void checkYesterday(Food food) {
        presentExpir = Double.parseDouble(String.valueOf(Period.between(LocalDate.now(),
                food.createDate).getDays()));
        fullExpir = Double.parseDouble(String.valueOf(Period.between(food.createDate,
                food.expiryDate).getDays()));
        yesterCoeff = (presentExpir - 1) / fullExpir;
        if (yesterCoeff < toQuat) {
            if (new Shop().checkContain(food)) {
                new Shop().deleteFood(food);
            }
        }
    }

    public boolean checkContain(Food food) {
        return trash.contains(food);
    }
}
