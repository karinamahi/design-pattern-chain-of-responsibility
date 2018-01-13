package com.learning.pattern.chain.desconto.controllers;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learning.pattern.chain.desconto.models.Item;
import com.learning.pattern.chain.desconto.models.Orcamento;

public class CalculadorDeDescontosTest {

    private CalculadorDeDescontos calculador;
    
    @BeforeClass
    public void init(){
	this.calculador = new CalculadorDeDescontos();
    }
    
    @Test
    public void deveCalcularDesconto(){
	Orcamento orcamento = new Orcamento(500.0);
	orcamento.adicionaItem(new Item("caneta", 250.0));
	orcamento.adicionaItem(new Item("livro", 250.0));
	double desconto = this.calculador.calcula(orcamento);
	Assert.assertEquals(desconto, 0.0);
	System.out.println("Desconto: " + desconto);
    }
    
    @Test
    public void deveCalcularDescontoPorMaisDeCincoItens(){
	Orcamento orcamento = new Orcamento(500.0);
	orcamento.adicionaItem(new Item("caneta", 50.0));
	orcamento.adicionaItem(new Item("livro", 50.0));
	orcamento.adicionaItem(new Item("caderno", 50.0));
	orcamento.adicionaItem(new Item("apontador", 50.0));
	orcamento.adicionaItem(new Item("tesoura", 50.0));
	orcamento.adicionaItem(new Item("régua", 50.0));
	double desconto = this.calculador.calcula(orcamento);
	System.out.println("Desconto: " + desconto);
	Assert.assertTrue(desconto > 0);
    }
    
    @Test
    public void deveCalcularDescontoPorMaisDeQuinhentosReais(){
	Orcamento orcamento = new Orcamento(600.0);
	orcamento.adicionaItem(new Item("caneta", 50.0));
	orcamento.adicionaItem(new Item("caderno", 50.0));
	double desconto = this.calculador.calcula(orcamento);
	System.out.println("Desconto: " + desconto);
	Assert.assertTrue(desconto > 0);
    }
    
    @Test
    public void deveCalcularDescontoPorVendaCasada(){
	Orcamento orcamento = new Orcamento(500.0);
	orcamento.adicionaItem(new Item("caneta", 10.0));
	orcamento.adicionaItem(new Item("lapis", 10.0));
	double desconto = this.calculador.calcula(orcamento);
	System.out.println("Desconto: " + desconto);
	Assert.assertTrue(desconto > 0);
    }

}
