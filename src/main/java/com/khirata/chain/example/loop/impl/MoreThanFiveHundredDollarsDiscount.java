package com.khirata.chain.example.loop.impl;

import com.khirata.chain.example.loop.models.PriceEstimate;
import com.khirata.chain.example.loop.Discount;

public class MoreThanFiveHundredDollarsDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getPrice() > 500) {
            return priceEstimate.getPrice() * 0.07;
        }
        return 0.0;
    }
}
