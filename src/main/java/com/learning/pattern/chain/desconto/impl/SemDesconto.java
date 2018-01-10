package com.learning.pattern.chain.desconto.impl;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.models.Orcamento;

public class SemDesconto implements Desconto{

    public double desconta(Orcamento orcamento) {
	return 0;
    }

    public void setDesconto(Desconto proximo) {
	
    }

}
