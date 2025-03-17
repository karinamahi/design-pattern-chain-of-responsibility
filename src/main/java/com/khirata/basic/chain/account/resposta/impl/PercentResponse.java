package com.khirata.basic.chain.account.resposta.impl;

import com.khirata.basic.chain.account.resposta.Response;
import com.khirata.basic.chain.account.models.Account;
import com.khirata.basic.chain.account.models.Format;
import com.khirata.basic.chain.account.models.Request;

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
