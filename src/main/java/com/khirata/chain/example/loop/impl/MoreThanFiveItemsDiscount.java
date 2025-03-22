package com.khirata.chain.example.loop.impl;

import com.khirata.chain.example.loop.Discount;
import com.khirata.chain.example.loop.models.PriceEstimate;

public class MoreThanFiveItemsDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getItens().size() > 5) {
            return priceEstimate.getPrice() * 0.1;
        }
        return 0.0;
    }
}
