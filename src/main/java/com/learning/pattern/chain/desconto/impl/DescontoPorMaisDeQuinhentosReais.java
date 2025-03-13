package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Discount;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class DescontoPorMaisDeQuinhentosReais implements Discount {
    
    private Discount proximo;

    public double calculateDiscount(PriceEstimate priceEstimate) {
	if(priceEstimate.getPrice() >  500){
	    return priceEstimate.getPrice() * 0.07;
	}
	return proximo.calculateDiscount(priceEstimate);
    }

    public void setDiscount(Discount next) {
	this.proximo = next;
    }

    
}
