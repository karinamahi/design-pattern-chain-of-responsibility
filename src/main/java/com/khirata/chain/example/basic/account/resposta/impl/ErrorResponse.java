package com.khirata.chain.example.basic.account.resposta.impl;

import com.khirata.chain.example.basic.account.resposta.Response;
import com.khirata.chain.example.basic.account.models.Account;
import com.khirata.chain.example.basic.account.models.Request;

public class ErrorResponse implements Response {

    @Override
    public void reply(Request request, Account account) {
        System.out.println("The account could not be printed.");
    }
}
