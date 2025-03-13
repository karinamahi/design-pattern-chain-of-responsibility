package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class SemDesconto implements Desconto{

    public double desconta(PriceEstimate priceEstimate) {
	return 0;
    }

    public void setDesconto(Desconto proximo) {
	
    }

}
