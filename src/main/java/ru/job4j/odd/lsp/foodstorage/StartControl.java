package ru.job4j.odd.lsp.foodstorage;

import java.util.List;

public class StartControl {
    List<Storage> storages;

    public StartControl(Warehouse warehouse, Shop shop, Trash trash) {
        this.storages.add(warehouse);
        this.storages.add(shop);
        this.storages.add(trash);
    }

    public void activateCQ(List<Storage> storages) {
        ControllQuality cq = new ControllQuality(storages);
    }
}
