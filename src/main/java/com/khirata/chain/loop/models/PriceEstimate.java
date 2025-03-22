package com.khirata.chain.loop.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceEstimate {

    private double price;
    private List<Item> itens;

    public PriceEstimate(double price) {
        this.price = price;
        this.itens = new ArrayList<Item>();
    }

    public double getPrice() {
        return price;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void addItem(Item item) {
        itens.add(item);
    }
}
