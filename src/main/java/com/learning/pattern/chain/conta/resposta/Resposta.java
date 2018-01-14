package com.learning.pattern.chain.conta.resposta;

import com.learning.pattern.chain.conta.models.Conta;
import com.learning.pattern.chain.conta.models.Requisicao;

public interface Resposta {
   
    void responde(Requisicao requisicao, Conta conta);
}
