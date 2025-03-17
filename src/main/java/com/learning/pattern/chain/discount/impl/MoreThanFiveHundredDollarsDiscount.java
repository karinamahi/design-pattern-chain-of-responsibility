package com.learning.pattern.chain.discount.impl;

import com.learning.pattern.chain.discount.Discount;
import com.learning.pattern.chain.discount.models.PriceEstimate;

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
