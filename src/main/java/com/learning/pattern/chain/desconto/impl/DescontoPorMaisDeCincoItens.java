package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.Orcamento;

public class DescontoPorMaisDeCincoItens implements Desconto{
    
    private Desconto proximo;

    public double desconta(Orcamento orcamento) {
	if(orcamento.getItens().size() > 5){
	    return orcamento.getValor() * 0.1;
	}
	return proximo.desconta(orcamento);
    }

    public void setDesconto(Desconto proximo) {
	this.proximo = proximo;
    }

}
