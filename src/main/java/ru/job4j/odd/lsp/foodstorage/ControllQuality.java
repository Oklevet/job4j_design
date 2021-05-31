package ru.job4j.odd.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private short discount;
    private final double quat     = 0.25D;
    private final double toQuat   = 0.75D;
    private final double full     = 1D;
    List<List<Food>> allStores;
    Warehouse warehouse;
    Shop shop;
    Trash trash;

    public ControllQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = new Warehouse();
        this.shop = new Shop();
        this.trash = new Trash();

        this.allStores.add(warehouse.warehouse);
        this.allStores.add(shop.shop);
        this.allStores.add(trash.trash);
    }

    void locateFood(Food food) {
        if (warehouse.accept(food)) {
            warehouse.addFood(food);
        } else if (shop.accept(food)) {
            shop.addFood(food);
        } else if (trash.accept(food)) {
            trash.accept(food);
        }
    }

    void resort() {
        List<Food> foods = new ArrayList<>();
        for (List<Food> lists : allStores) {
            foods.addAll(lists);
            lists.clear();
        }
        for (Food food : foods) {
            locateFood(food);
        }
    }
}
