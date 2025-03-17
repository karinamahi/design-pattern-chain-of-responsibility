package com.khirata.loop.chain.impl;

import com.khirata.loop.chain.Discount;
import com.khirata.loop.chain.models.PriceEstimate;

public class MoreThanFiveHundredDollarsDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getPrice() > 500) {
            return priceEstimate.getPrice() * 0.07;
        }
        return 0.0;
    }
}
