package com.learning.pattern.chain.account.resposta;

import com.learning.pattern.chain.account.models.Account;
import com.learning.pattern.chain.account.models.Request;

public interface Response {
   
    void reply(Request request, Account account);
}
