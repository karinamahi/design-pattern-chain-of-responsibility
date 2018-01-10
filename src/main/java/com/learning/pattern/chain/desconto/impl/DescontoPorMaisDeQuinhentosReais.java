package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.Orcamento;

public class DescontoPorMaisDeQuinhentosReais implements Desconto{
    
    private Desconto proximo;

    public double desconta(Orcamento orcamento) {
	if(orcamento.getValor() >  500){
	    return orcamento.getValor() * 0.07;
	}
	return proximo.desconta(orcamento);
    }

    public void setDesconto(Desconto proximo) {
	this.proximo = proximo;
    }

    
}
