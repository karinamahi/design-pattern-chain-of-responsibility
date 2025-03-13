package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;

public class PercentResponse implements Response {

    private Response otherResponse;

    public PercentResponse(Response otherResponse) {
        super();
        this.otherResponse = otherResponse;
    }

    @Override
    public void reply(Request request, Account account) {
        if (request.getFormat().equals(Format.PERCENT)) {
            System.out.println(account.getOwner() + "%" + account.getBalance());
        } else {
            otherResponse.reply(request, account);
        }
    }
}
