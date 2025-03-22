package com.khirata.chain.loop.impl;

import com.khirata.chain.loop.models.PriceEstimate;
import com.khirata.chain.loop.Discount;

public class NoDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        return 0;
    }
}
