package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Discount;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class MoreThanFiveHundredDollarsDiscount implements Discount {

    private Discount next;

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getPrice() > 500) {
            return priceEstimate.getPrice() * 0.07;
        }
        return next.calculateDiscount(priceEstimate);
    }

    public void setDiscount(Discount next) {
        this.next = next;
    }

}
