package com.learning.pattern.chain.desconto;

import com.learning.pattern.chain.desconto.models.PriceEstimate;

public interface Desconto {

    double desconta(PriceEstimate priceEstimate);
    void setDesconto(Desconto proximo);
    
}
