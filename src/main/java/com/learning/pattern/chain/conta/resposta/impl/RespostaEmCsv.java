package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Resposta;

public class RespostaEmCsv implements Resposta{
    
    private Resposta outraResposta;
    
    public RespostaEmCsv(Resposta outraResposta) {
	super();
	this.outraResposta = outraResposta;
    }

    @Override
    public void responde(Request request, Account account) {
	if(request.getFormat().equals(Format.CSV)){
	    System.out.println(account.getTitular() + "," + account.getSaldo());
	}else{
	    outraResposta.responde(request, account);
	}
	
    }
}
