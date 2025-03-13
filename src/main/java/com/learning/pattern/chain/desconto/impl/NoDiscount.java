package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Discount;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class NoDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        return 0;
    }

    public void setDiscount(Discount next) {

    }
}
