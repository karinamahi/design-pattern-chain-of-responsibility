package com.learning.pattern.chain.conta.controllers;

import org.testng.annotations.Test;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;

public class AccountControllerTest {

    @Test
    public void deveImprimirXml() {
        AccountController controller = new AccountController();
        Account account = new Account("Karina", 1.0);
        controller.printAccount(Format.XML, account);
    }

    @Test
    public void deveImprimirCsv() {
        AccountController controller = new AccountController();
        Account account = new Account("Karina", 1.0);
        controller.printAccount(Format.CSV, account);
    }

    @Test
    public void deveImprimirPorcento() {
        AccountController controller = new AccountController();
        Account account = new Account("Karina", 1.0);
        controller.printAccount(Format.PERCENT, account);
    }
}
