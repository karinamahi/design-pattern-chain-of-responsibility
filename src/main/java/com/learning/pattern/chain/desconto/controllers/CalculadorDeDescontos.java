package com.learning.pattern.chain.desconto.controllers;

import com.learning.pattern.chain.desconto.Discount;
import com.learning.pattern.chain.desconto.impl.DescontoPorMaisDeCincoItens;
import com.learning.pattern.chain.desconto.impl.DescontoPorMaisDeQuinhentosReais;
import com.learning.pattern.chain.desconto.impl.DescontoPorVendaCasada;
import com.learning.pattern.chain.desconto.impl.SemDesconto;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class CalculadorDeDescontos {

    public double calcula(PriceEstimate priceEstimate) {
	Discount d1 = new DescontoPorMaisDeCincoItens();
	Discount d2 = new DescontoPorMaisDeQuinhentosReais();
	Discount d3 = new DescontoPorVendaCasada();
	Discount d4 = new SemDesconto();

	d1.setDiscount(d2);
	d2.setDiscount(d3);
	d3.setDiscount(d4);

	return d1.calculateDiscount(priceEstimate);
    }

}
