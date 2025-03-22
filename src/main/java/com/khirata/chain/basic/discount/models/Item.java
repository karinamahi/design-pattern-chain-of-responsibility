package com.khirata.chain.basic.discount.models;

public class Item {

    private String name;
    private double price;

    public Item(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
