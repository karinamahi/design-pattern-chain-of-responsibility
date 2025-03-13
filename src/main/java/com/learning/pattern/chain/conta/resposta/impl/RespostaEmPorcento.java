package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;

public class RespostaEmPorcento implements Response {
    
    private Response outraResposta;
    
    public RespostaEmPorcento(Response outraResposta) {
	super();
	this.outraResposta = outraResposta;
    }

    @Override
    public void reply(Request request, Account account) {
	if(request.getFormat().equals(Format.PERCENT)){
	    System.out.println(account.getOwner() + "%" + account.getBalance());
	}else{
	    outraResposta.reply(request, account);
	}
    }
}
