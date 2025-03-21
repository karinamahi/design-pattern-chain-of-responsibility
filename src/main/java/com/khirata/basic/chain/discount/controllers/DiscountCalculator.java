package com.khirata.basic.chain.discount.controllers;

import com.khirata.basic.chain.discount.Discount;
import com.khirata.basic.chain.discount.impl.BundlingDiscount;
import com.khirata.basic.chain.discount.impl.MoreThanFiveHundredDollarsDiscount;
import com.khirata.basic.chain.discount.impl.MoreThanFiveItemsDiscount;
import com.khirata.basic.chain.discount.impl.NoDiscount;
import com.khirata.basic.chain.discount.models.PriceEstimate;

public class DiscountCalculator {

    public double calc(PriceEstimate priceEstimate) {
        Discount d1 = new MoreThanFiveItemsDiscount();
        Discount d2 = new MoreThanFiveHundredDollarsDiscount();
        Discount d3 = new BundlingDiscount();
        Discount d4 = new NoDiscount();

        d1.setDiscount(d2);
        d2.setDiscount(d3);
        d3.setDiscount(d4);

        return d1.calculateDiscount(priceEstimate);
    }
}
