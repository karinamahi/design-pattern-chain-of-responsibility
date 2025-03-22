package com.khirata.chain.example.basic.account.controllers;

import com.khirata.chain.example.basic.account.resposta.Response;
import com.khirata.chain.example.basic.account.models.Account;
import com.khirata.chain.example.basic.account.models.Format;
import com.khirata.chain.example.basic.account.models.Request;
import com.khirata.chain.example.basic.account.resposta.impl.ErrorResponse;
import com.khirata.chain.example.basic.account.resposta.impl.CsvResponse;
import com.khirata.chain.example.basic.account.resposta.impl.PercentResponse;
import com.khirata.chain.example.basic.account.resposta.impl.XmlResponse;

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
