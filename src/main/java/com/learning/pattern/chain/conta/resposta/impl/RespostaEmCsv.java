package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Conta;
import com.learning.pattern.chain.conta.models.Formato;
import com.learning.pattern.chain.conta.models.Requisicao;
import com.learning.pattern.chain.conta.resposta.Resposta;

public class RespostaEmCsv implements Resposta{
    
    private Resposta outraResposta;
    
    public RespostaEmCsv(Resposta outraResposta) {
	super();
	this.outraResposta = outraResposta;
    }

    @Override
    public void responde(Requisicao requisicao, Conta conta) {
	if(requisicao.getFormato().equals(Formato.CSV)){
	    System.out.println(conta.getTitular() + "," + conta.getSaldo());
	}else{
	    outraResposta.responde(requisicao, conta);
	}
	
    }
}
