package com.learning.pattern.chain.account.controllers;

import org.testng.annotations.Test;

import com.learning.pattern.chain.account.models.Account;
import com.learning.pattern.chain.account.models.Format;

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
