package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class DescontoPorMaisDeCincoItens implements Desconto{
    
    private Desconto proximo;

    public double desconta(PriceEstimate priceEstimate) {
	if(priceEstimate.getItens().size() > 5){
	    return priceEstimate.getPrice() * 0.1;
	}
	return proximo.desconta(priceEstimate);
    }

    public void setDesconto(Desconto proximo) {
	this.proximo = proximo;
    }

}
