package com.learning.pattern.chain.desconto.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.Item;
import com.learning.pattern.chain.desconto.models.Orcamento;

public class DescontoPorVendaCasada implements Desconto{
    
    private Desconto proximo;

    public double desconta(Orcamento orcamento) {
	boolean contemLapis = contem("LAPIS", orcamento);
	boolean contemCaneta = contem("CANETA", orcamento);
	if(contemCaneta && contemLapis){
	    return 1.00;
	}
	return proximo.desconta(orcamento);
    }

    public void setDesconto(Desconto proximo) {
	this.proximo = proximo;
    }

    private boolean contem(String nomeDoItem, Orcamento orcamento){
	List<Item> list = orcamento.getItens().stream().filter(item -> {
	    return nomeDoItem.equalsIgnoreCase(item.getNome());
	}).collect(Collectors.toList());
	if(list == null || list.size() <=0) return false;
	return true;
    }
}
