package ru.job4j.odd.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    void locateFood(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.addFood(food);
                break;
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
