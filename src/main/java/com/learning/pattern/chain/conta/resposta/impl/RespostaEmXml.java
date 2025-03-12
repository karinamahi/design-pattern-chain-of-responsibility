package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Conta;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Requisicao;
import com.learning.pattern.chain.conta.resposta.Resposta;

public class RespostaEmXml implements Resposta{
    
    private Resposta outraResposta;
    
    public RespostaEmXml(Resposta outraResposta) {
	super();
	this.outraResposta = outraResposta;
    }

    @Override
    public void responde(Requisicao requisicao, Conta conta) {
	if(requisicao.getFormato().equals(Format.XML)){
	    System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo() + "</saldo></conta>");
	}else{
	    outraResposta.responde(requisicao, conta);
	}
	
    }
}
