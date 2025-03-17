package com.learning.pattern.chain.account.resposta.impl;

import com.learning.pattern.chain.account.models.Account;
import com.learning.pattern.chain.account.models.Request;
import com.learning.pattern.chain.account.resposta.Response;

public class ErrorResponse implements Response {

    @Override
    public void reply(Request request, Account account) {
        System.out.println("The account could not be printed.");
    }
}
