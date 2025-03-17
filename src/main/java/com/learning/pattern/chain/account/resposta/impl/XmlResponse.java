package com.learning.pattern.chain.account.resposta.impl;

import com.learning.pattern.chain.account.models.Account;
import com.learning.pattern.chain.account.models.Format;
import com.learning.pattern.chain.account.models.Request;
import com.learning.pattern.chain.account.resposta.Response;

public class XmlResponse implements Response {

    private Response otherResponse;

    public XmlResponse(Response otherResponse) {
        super();
        this.otherResponse = otherResponse;
    }

    @Override
    public void reply(Request request, Account account) {
        if (request.getFormat().equals(Format.XML)) {
            System.out.println("<account><owner>" + account.getOwner() + "</owner><balance>" + account.getBalance() + "</balance></account>");
        } else {
            otherResponse.reply(request, account);
        }
    }
}
