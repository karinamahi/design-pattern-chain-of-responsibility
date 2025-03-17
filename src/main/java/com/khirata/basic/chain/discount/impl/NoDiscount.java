package com.khirata.basic.chain.discount.impl;

import com.khirata.basic.chain.discount.Discount;
import com.khirata.basic.chain.discount.models.PriceEstimate;

public class NoDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        return 0;
    }

    public void setDiscount(Discount next) {

    }
}
