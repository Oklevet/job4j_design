package ru.job4j.odd.lsp.foodstorage;

public class ControllQuality {
    private short discount;
    private final double quat     = 0.25D;
    private final double toQuat   = 0.75D;
    private final double full     = 1D;

    void locateFood(Food food) {
        if (new Warehouse().accept(food)) {
            new Warehouse().addFood(food);
        } else if (new Shop().accept(food)) {
            new Shop().addFood(food);
        } else if (new Trash().accept(food)) {
            new Trash().accept(food);
        }
    }
}
