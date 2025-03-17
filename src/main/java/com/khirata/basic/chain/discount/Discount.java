package com.khirata.basic.chain.discount;

import com.khirata.basic.chain.discount.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

    void setDiscount(Discount next);

}
