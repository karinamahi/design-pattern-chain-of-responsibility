package com.khirata.chain.example.basic.account.resposta.impl;

import com.khirata.chain.example.basic.account.resposta.Response;
import com.khirata.chain.example.basic.account.models.Account;
import com.khirata.chain.example.basic.account.models.Format;
import com.khirata.chain.example.basic.account.models.Request;

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
