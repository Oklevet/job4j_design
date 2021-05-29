package ru.job4j.odd.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Trash {
    List<Food> trash = new ArrayList<>();
    public void addFood(Food food) {
        trash.add(food);
    }
}
