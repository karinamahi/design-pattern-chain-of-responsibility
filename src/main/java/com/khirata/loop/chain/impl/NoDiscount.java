package com.khirata.loop.chain.impl;

import com.khirata.loop.chain.Discount;
import com.khirata.loop.chain.models.PriceEstimate;

public class NoDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        return 0;
    }
}
