package com.khirata.chain.example.loop.controllers;

import com.khirata.chain.example.loop.impl.MoreThanFiveHundredDollarsDiscount;
import com.khirata.chain.example.loop.models.PriceEstimate;
import com.khirata.chain.example.loop.Discount;
import com.khirata.chain.example.loop.impl.BundlingDiscount;
import com.khirata.chain.example.loop.impl.MoreThanFiveItemsDiscount;
import com.khirata.chain.example.loop.impl.NoDiscount;

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
