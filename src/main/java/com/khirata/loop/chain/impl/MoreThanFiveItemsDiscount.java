package com.khirata.loop.chain.impl;

import com.khirata.loop.chain.Discount;
import com.khirata.loop.chain.models.PriceEstimate;

public class MoreThanFiveItemsDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getItens().size() > 5) {
            return priceEstimate.getPrice() * 0.1;
        }
        return 0.0;
    }
}
