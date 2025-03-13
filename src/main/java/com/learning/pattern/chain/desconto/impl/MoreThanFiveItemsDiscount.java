package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Discount;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class MoreThanFiveItemsDiscount implements Discount {

    private Discount next;

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getItens().size() > 5) {
            return priceEstimate.getPrice() * 0.1;
        }
        return next.calculateDiscount(priceEstimate);
    }

    public void setDiscount(Discount next) {
        this.next = next;
    }

}
