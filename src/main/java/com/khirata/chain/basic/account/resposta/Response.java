package com.khirata.chain.basic.account.resposta;

import com.khirata.chain.basic.account.models.Account;
import com.khirata.chain.basic.account.models.Request;

public interface Response {
   
    void reply(Request request, Account account);
}
