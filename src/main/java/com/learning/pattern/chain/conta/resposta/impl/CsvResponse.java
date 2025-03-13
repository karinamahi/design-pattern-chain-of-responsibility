package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;

public class CsvResponse implements Response {

    private Response otherResponse;

    public CsvResponse(Response otherResponse) {
        super();
        this.otherResponse = otherResponse;
    }

    @Override
    public void reply(Request request, Account account) {
        if (request.getFormat().equals(Format.CSV)) {
            System.out.println(account.getOwner() + "," + account.getBalance());
        } else {
            otherResponse.reply(request, account);
        }
    }
}
