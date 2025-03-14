package com.learning.pattern.chain.discount;

import com.learning.pattern.chain.discount.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

    void setDiscount(Discount next);

}
