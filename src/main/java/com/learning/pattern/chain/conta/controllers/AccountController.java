package com.learning.pattern.chain.conta.controllers;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;
import com.learning.pattern.chain.conta.resposta.impl.ErrorResponse;
import com.learning.pattern.chain.conta.resposta.impl.CsvResponse;
import com.learning.pattern.chain.conta.resposta.impl.PercentResponse;
import com.learning.pattern.chain.conta.resposta.impl.XmlResponse;

public class AccountController {

    public void printAccount(Format format, Account account) {

        Response errorResponse = new ErrorResponse();
        Response percentResponse = new PercentResponse(errorResponse);
        Response csvResponse = new CsvResponse(percentResponse);
        Response xmlResponse = new XmlResponse(csvResponse);

        Request request = new Request(format);
        xmlResponse.reply(request, account);
    }
}
