package com.learning.pattern.chain.conta.controllers;

import org.testng.annotations.Test;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;

public class AccountControllerTest {

    @Test
    public void deveImprimirXml() {
        ContaController controller = new ContaController();
        Account account = new Account("Karina", 1.0);
        controller.imprimeConta(Format.XML, account);
    }

    @Test
    public void deveImprimirCsv() {
        ContaController controller = new ContaController();
        Account account = new Account("Karina", 1.0);
        controller.imprimeConta(Format.CSV, account);
    }

    @Test
    public void deveImprimirPorcento() {
        ContaController controller = new ContaController();
        Account account = new Account("Karina", 1.0);
        controller.imprimeConta(Format.PERCENT, account);
    }
}
