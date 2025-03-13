package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class DescontoPorMaisDeQuinhentosReais implements Desconto{
    
    private Desconto proximo;

    public double desconta(PriceEstimate priceEstimate) {
	if(priceEstimate.getPrice() >  500){
	    return priceEstimate.getPrice() * 0.07;
	}
	return proximo.desconta(priceEstimate);
    }

    public void setDesconto(Desconto proximo) {
	this.proximo = proximo;
    }

    
}
