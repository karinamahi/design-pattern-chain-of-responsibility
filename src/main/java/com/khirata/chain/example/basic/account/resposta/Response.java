package com.khirata.chain.example.basic.account.resposta;

import com.khirata.chain.example.basic.account.models.Account;
import com.khirata.chain.example.basic.account.models.Request;

public interface Response {
   
    void reply(Request request, Account account);
}
