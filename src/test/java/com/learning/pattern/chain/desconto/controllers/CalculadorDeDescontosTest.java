package com.learning.pattern.chain.desconto.controllers;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learning.pattern.chain.desconto.models.Item;
import com.learning.pattern.chain.desconto.models.PriceEstimate;

public class CalculadorDeDescontosTest {

    private CalculadorDeDescontos calculador;

    @BeforeClass
    public void init() {
        this.calculador = new CalculadorDeDescontos();
    }

    @Test
    public void deveCalcularDesconto() {
        PriceEstimate priceEstimate = new PriceEstimate(500.0);
        priceEstimate.addItem(new Item("pen", 250.0));
        priceEstimate.addItem(new Item("book", 250.0));
        double discount = this.calculador.calcula(priceEstimate);
        Assert.assertEquals(discount, 0.0);
        System.out.println("Discount: " + discount);
    }

    @Test
    public void deveCalcularDescontoPorMaisDeCincoItens() {
        PriceEstimate priceEstimate = new PriceEstimate(500.0);
        priceEstimate.addItem(new Item("caneta", 50.0));
        priceEstimate.addItem(new Item("livro", 50.0));
        priceEstimate.addItem(new Item("caderno", 50.0));
        priceEstimate.addItem(new Item("apontador", 50.0));
        priceEstimate.addItem(new Item("tesoura", 50.0));
        priceEstimate.addItem(new Item("régua", 50.0));
        double desconto = this.calculador.calcula(priceEstimate);
        System.out.println("Desconto: " + desconto);
        Assert.assertTrue(desconto > 0);
    }

    @Test
    public void deveCalcularDescontoPorMaisDeQuinhentosReais() {
        PriceEstimate priceEstimate = new PriceEstimate(600.0);
        priceEstimate.addItem(new Item("caneta", 50.0));
        priceEstimate.addItem(new Item("caderno", 50.0));
        double desconto = this.calculador.calcula(priceEstimate);
        System.out.println("Desconto: " + desconto);
        Assert.assertTrue(desconto > 0);
    }

    @Test
    public void deveCalcularDescontoPorVendaCasada() {
        PriceEstimate priceEstimate = new PriceEstimate(500.0);
        priceEstimate.addItem(new Item("pen", 10.0));
        priceEstimate.addItem(new Item("pencil", 10.0));
        double discount = this.calculador.calcula(priceEstimate);
        System.out.println("Desconto: " + discount);
        Assert.assertTrue(discount > 0);
    }
}
