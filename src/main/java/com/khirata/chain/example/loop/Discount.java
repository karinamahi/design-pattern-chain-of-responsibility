package com.khirata.chain.example.loop;

import com.khirata.chain.example.loop.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

}
