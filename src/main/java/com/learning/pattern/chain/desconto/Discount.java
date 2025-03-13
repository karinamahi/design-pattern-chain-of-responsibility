package com.learning.pattern.chain.desconto;

import com.learning.pattern.chain.desconto.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

    void setDiscount(Discount next);

}
