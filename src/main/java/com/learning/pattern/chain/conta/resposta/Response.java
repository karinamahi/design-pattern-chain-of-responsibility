package com.learning.pattern.chain.conta.resposta;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Request;

public interface Response {
   
    void reply(Request request, Account account);
}
