package com.khirata.basic.chain.account.resposta.impl;

import com.khirata.basic.chain.account.resposta.Response;
import com.khirata.basic.chain.account.models.Account;
import com.khirata.basic.chain.account.models.Request;

public class ErrorResponse implements Response {

    @Override
    public void reply(Request request, Account account) {
        System.out.println("The account could not be printed.");
    }
}
