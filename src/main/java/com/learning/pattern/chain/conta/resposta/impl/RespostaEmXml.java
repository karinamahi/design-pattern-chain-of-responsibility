package com.learning.pattern.chain.conta.resposta.impl;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;

public class RespostaEmXml implements Response {
    
    private Response outraResposta;
    
    public RespostaEmXml(Response outraResposta) {
	super();
	this.outraResposta = outraResposta;
    }

    @Override
    public void reply(Request request, Account account) {
	if(request.getFormat().equals(Format.XML)){
	    System.out.println("<conta><titular>" + account.getOwner() + "</titular><saldo>" + account.getBalance() + "</saldo></conta>");
	}else{
	    outraResposta.reply(request, account);
	}
	
    }
}
