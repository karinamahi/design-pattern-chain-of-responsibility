package com.learning.pattern.chain.desconto.controllers;

import com.learning.pattern.chain.desconto.Discount;
import com.learning.pattern.chain.desconto.impl.DescontoPorMaisDeCincoItens;
import com.learning.pattern.chain.desconto.impl.DescontoPorMaisDeQuinhentosReais;
import com.learning.pattern.chain.desconto.impl.BundlingDiscount;
import com.learning.pattern.chain.desconto.impl.NoDiscount;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class CalculadorDeDescontos {

    public double calcula(PriceEstimate priceEstimate) {
	Discount d1 = new DescontoPorMaisDeCincoItens();
	Discount d2 = new DescontoPorMaisDeQuinhentosReais();
	Discount d3 = new BundlingDiscount();
	Discount d4 = new NoDiscount();

	d1.setDiscount(d2);
	d2.setDiscount(d3);
	d3.setDiscount(d4);

	return d1.calculateDiscount(priceEstimate);
    }

}
