package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;

public class ErrorResponse implements Response {

    @Override
    public void reply(Request request, Account account) {
        System.out.println("The account could not be printed.");
    }
}
