package com.khirata.chain.example.basic.account.controllers;

import org.testng.annotations.Test;

import com.khirata.chain.example.basic.account.models.Account;
import com.khirata.chain.example.basic.account.models.Format;

public class AccountControllerTest {

    @Test
    public void printXmlTest() {
        AccountController controller = new AccountController();
        Account account = new Account("Karina", 1.0);
        controller.printAccount(Format.XML, account);
    }

    @Test
    public void printCsvTest() {
        AccountController controller = new AccountController();
        Account account = new Account("Karina", 1.0);
        controller.printAccount(Format.CSV, account);
    }

    @Test
    public void printPercentTest() {
        AccountController controller = new AccountController();
        Account account = new Account("Karina", 1.0);
        controller.printAccount(Format.PERCENT, account);
    }
}
