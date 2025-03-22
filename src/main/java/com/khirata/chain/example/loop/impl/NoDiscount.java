package com.khirata.chain.example.loop.impl;

import com.khirata.chain.example.loop.models.PriceEstimate;
import com.khirata.chain.example.loop.Discount;

public class NoDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        return 0;
    }
}
