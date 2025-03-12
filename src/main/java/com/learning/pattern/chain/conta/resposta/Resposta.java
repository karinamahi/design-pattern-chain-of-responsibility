package com.learning.pattern.chain.conta.resposta;

import com.learning.pattern.chain.conta.models.Conta;
import com.learning.pattern.chain.conta.models.Request;

public interface Resposta {
   
    void responde(Request request, Conta conta);
}
