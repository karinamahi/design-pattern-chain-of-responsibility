package com.khirata.chain.loop;

import com.khirata.chain.loop.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

}
