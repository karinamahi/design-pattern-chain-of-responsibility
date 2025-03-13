package com.learning.pattern.chain.desconto.controllers;

import com.learning.pattern.chain.desconto.Desconto;
import com.learning.pattern.chain.desconto.impl.DescontoPorMaisDeCincoItens;
import com.learning.pattern.chain.desconto.impl.DescontoPorMaisDeQuinhentosReais;
import com.learning.pattern.chain.desconto.impl.DescontoPorVendaCasada;
import com.learning.pattern.chain.desconto.impl.SemDesconto;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class CalculadorDeDescontos {

    public double calcula(PriceEstimate priceEstimate) {
	Desconto d1 = new DescontoPorMaisDeCincoItens();
	Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
	Desconto d3 = new DescontoPorVendaCasada();
	Desconto d4 = new SemDesconto();

	d1.setDesconto(d2);
	d2.setDesconto(d3);
	d3.setDesconto(d4);

	return d1.desconta(priceEstimate);
    }

}
