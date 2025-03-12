package com.learning.pattern.chain.conta.controllers;

import org.testng.annotations.Test;

import com.learning.pattern.chain.conta.models.Conta;
import com.learning.pattern.chain.conta.models.Format;

public class ContaControllerTest {

    @Test
    public void deveImprimirXml() {
        ContaController controller = new ContaController();
        Conta conta = new Conta("Karina", 1.0);
        controller.imprimeConta(Format.XML, conta);
    }

    @Test
    public void deveImprimirCsv() {
        ContaController controller = new ContaController();
        Conta conta = new Conta("Karina", 1.0);
        controller.imprimeConta(Format.CSV, conta);
    }

    @Test
    public void deveImprimirPorcento() {
        ContaController controller = new ContaController();
        Conta conta = new Conta("Karina", 1.0);
        controller.imprimeConta(Format.PERCENT, conta);
    }
}
