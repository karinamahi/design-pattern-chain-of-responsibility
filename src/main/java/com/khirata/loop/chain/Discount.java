package com.khirata.loop.chain;

import com.khirata.loop.chain.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

}
