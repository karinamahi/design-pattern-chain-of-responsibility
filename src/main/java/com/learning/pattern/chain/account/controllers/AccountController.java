package com.learning.pattern.chain.account.controllers;

import com.learning.pattern.chain.account.models.Account;
import com.learning.pattern.chain.account.models.Format;
import com.learning.pattern.chain.account.models.Request;
import com.learning.pattern.chain.account.resposta.Response;
import com.learning.pattern.chain.account.resposta.impl.ErrorResponse;
import com.learning.pattern.chain.account.resposta.impl.CsvResponse;
import com.learning.pattern.chain.account.resposta.impl.PercentResponse;
import com.learning.pattern.chain.account.resposta.impl.XmlResponse;

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
