package ru.job4j.odd.lsp.foodstorage;

import java.time.LocalDate;
import java.time.Period;

public class ControllQuality {
    private short discount;
    private final double quat     = 0.25D;
    private final double toQuat   = 0.75D;
    private final double full     = 1D;

    void locateFood(Food food) {
        double presentExpir = Double.parseDouble(String.valueOf(Period.between(LocalDate.now(),
                food.createDate).getDays()));
        double fullExpir    = Double.parseDouble(String.valueOf(Period.between(food.createDate,
                food.expiryDate).getDays()));
        double coeffDelay = presentExpir / fullExpir;
        double yesterCoeff = (presentExpir - 1) / fullExpir;

        if (coeffDelay < quat) {
            Warehouse wh = new Warehouse();
            if (!wh.warehouse.contains(food)) {
                wh.addFood(food);
            }
        } else if (coeffDelay < toQuat) {
            Shop sh = new Shop();
            if (yesterCoeff < toQuat) {
                if (!sh.shop.contains(food)) {
                    sh.addFood(food);
                }
            } else {
                sh.addFood(food);
                new Warehouse().warehouse.remove(food);
            }
        } else if (coeffDelay <= full) {
            Shop sh = new Shop();
            if (yesterCoeff < full) {
                if (!sh.shop.contains(food)) {
                    food.setDiscount(discount);
                    sh.addFood(food);
                } else if (yesterCoeff < toQuat) {
                    sh.shop.remove(food);
                    food.setDiscount(discount);
                    sh.addFood(food);
                }
            }
        } else {
            new Trash().addFood(food);
            if (yesterCoeff < full) {
                new Shop().shop.remove(food);
            }
        }
    }
}
