package ru.job4j.odd.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private short discount;
    private final double quat     = 0.25D;
    private final double toQuat   = 0.75D;
    private final double full     = 1D;
    List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    void locateFood(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.addFood(food);
            }
        }
    }

    void resort() {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storages) {
            foods.addAll(storage.getListFood());
            storage.clearStorage();
        }
        for (Food food : foods) {
            locateFood(food);
        }
    }
}
