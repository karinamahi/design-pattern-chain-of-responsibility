package com.learning.pattern.chain.desconto.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.learning.pattern.chain.desconto.Discount;
import com.learning.pattern.chain.desconto.models.Item;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class DescontoPorVendaCasada implements Discount {
    
    private Discount proximo;

    public double calculateDiscount(PriceEstimate priceEstimate) {
	boolean contemLapis = contem("LAPIS", priceEstimate);
	boolean contemCaneta = contem("CANETA", priceEstimate);
	if(contemCaneta && contemLapis){
	    return 1.00;
	}
	return proximo.calculateDiscount(priceEstimate);
    }

    public void setDiscount(Discount next) {
	this.proximo = next;
    }

    private boolean contem(String nomeDoItem, PriceEstimate priceEstimate){
	List<Item> list = priceEstimate.getItens().stream().filter(item -> {
	    return nomeDoItem.equalsIgnoreCase(item.getName());
	}).collect(Collectors.toList());
	if(list == null || list.size() <=0) return false;
	return true;
    }
}
