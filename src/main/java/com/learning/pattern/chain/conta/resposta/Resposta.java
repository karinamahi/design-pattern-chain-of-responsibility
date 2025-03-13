package com.learning.pattern.chain.conta.resposta;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Request;

public interface Resposta {
   
    void responde(Request request, Account account);
}
