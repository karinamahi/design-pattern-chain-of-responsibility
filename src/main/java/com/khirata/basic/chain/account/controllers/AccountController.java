package com.khirata.basic.chain.account.controllers;

import com.khirata.basic.chain.account.resposta.Response;
import com.khirata.basic.chain.account.models.Account;
import com.khirata.basic.chain.account.models.Format;
import com.khirata.basic.chain.account.models.Request;
import com.khirata.basic.chain.account.resposta.impl.ErrorResponse;
import com.khirata.basic.chain.account.resposta.impl.CsvResponse;
import com.khirata.basic.chain.account.resposta.impl.PercentResponse;
import com.khirata.basic.chain.account.resposta.impl.XmlResponse;

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
