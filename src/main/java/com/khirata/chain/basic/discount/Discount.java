package com.khirata.chain.basic.discount;

import com.khirata.chain.basic.discount.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

    void setDiscount(Discount next);

}
