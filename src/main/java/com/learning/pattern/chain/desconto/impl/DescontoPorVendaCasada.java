package com.learning.pattern.chain.desconto.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.Item;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class DescontoPorVendaCasada implements Desconto{
    
    private Desconto proximo;

    public double desconta(PriceEstimate priceEstimate) {
	boolean contemLapis = contem("LAPIS", priceEstimate);
	boolean contemCaneta = contem("CANETA", priceEstimate);
	if(contemCaneta && contemLapis){
	    return 1.00;
	}
	return proximo.desconta(priceEstimate);
    }

    public void setDesconto(Desconto proximo) {
	this.proximo = proximo;
    }

    private boolean contem(String nomeDoItem, PriceEstimate priceEstimate){
	List<Item> list = priceEstimate.getItens().stream().filter(item -> {
	    return nomeDoItem.equalsIgnoreCase(item.getName());
	}).collect(Collectors.toList());
	if(list == null || list.size() <=0) return false;
	return true;
    }
}
