package com.khirata.chain.example.basic.discount.impl;

import com.khirata.chain.example.basic.discount.Discount;
import com.khirata.chain.example.basic.discount.models.PriceEstimate;

public class NoDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        return 0;
    }

    public void setDiscount(Discount next) {

    }
}
