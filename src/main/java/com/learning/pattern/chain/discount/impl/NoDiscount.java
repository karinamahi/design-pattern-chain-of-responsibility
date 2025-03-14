package com.learning.pattern.chain.discount.impl;

import com.learning.pattern.chain.discount.Discount;
import com.learning.pattern.chain.discount.models.PriceEstimate;

public class NoDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        return 0;
    }

    public void setDiscount(Discount next) {

    }
}
