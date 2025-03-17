package com.khirata.basic.chain.account.resposta;

import com.khirata.basic.chain.account.models.Account;
import com.khirata.basic.chain.account.models.Request;

public interface Response {
   
    void reply(Request request, Account account);
}
