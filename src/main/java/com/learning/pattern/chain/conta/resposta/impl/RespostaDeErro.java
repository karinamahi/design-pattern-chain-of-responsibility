package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Conta;
import com.learning.pattern.chain.conta.models.Requisicao;
import com.learning.pattern.chain.conta.resposta.Resposta;

public class RespostaDeErro implements Resposta {

    @Override
    public void responde(Requisicao requisicao, Conta conta) {
	System.out.println("Não foi possível imprimir a conta.");
    }

}
