package com.khirata.chain.example.basic.discount;

import com.khirata.chain.example.basic.discount.models.PriceEstimate;

public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

    void setDiscount(Discount next);

}
