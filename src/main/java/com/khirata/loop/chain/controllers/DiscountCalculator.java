package com.khirata.loop.chain.controllers;

import com.khirata.loop.chain.Discount;
import com.khirata.loop.chain.impl.BundlingDiscount;
import com.khirata.loop.chain.impl.MoreThanFiveHundredDollarsDiscount;
import com.khirata.loop.chain.impl.MoreThanFiveItemsDiscount;
import com.khirata.loop.chain.impl.NoDiscount;
import com.khirata.loop.chain.models.PriceEstimate;

import java.util.Arrays;
import java.util.List;

public class DiscountCalculator {

    public double calc(PriceEstimate priceEstimate) {
        Discount d1 = new MoreThanFiveItemsDiscount();
        Discount d2 = new MoreThanFiveHundredDollarsDiscount();
        Discount d3 = new BundlingDiscount();
        Discount d4 = new NoDiscount();

        List<Discount> discountList= Arrays.asList(d1, d2, d3, d4);

        double totalDiscount = 0.0;

        for (Discount discount: discountList) {
            totalDiscount += discount.calculateDiscount(priceEstimate);
        }

        return totalDiscount;
    }
}
