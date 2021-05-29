package ru.job4j.odd.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<Food> shop = new ArrayList<>();
    public void addFood(Food food) {
        shop.add(food);
    }
}
