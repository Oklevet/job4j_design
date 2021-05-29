package ru.job4j.odd.lsp.foodstorage;

import java.time.Instant;
import java.time.LocalDate;

public class Food {
    String name;
    LocalDate expiryDate;
    LocalDate createDate;
    double price;
    short discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price, short discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public short getDiscount() {
        return discount;
    }
}
