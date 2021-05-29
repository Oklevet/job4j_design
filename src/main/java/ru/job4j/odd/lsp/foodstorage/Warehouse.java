package ru.job4j.odd.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Food> warehouse = new ArrayList<>();
    public void addFood(Food food) {
        warehouse.add(food);
    }
}
