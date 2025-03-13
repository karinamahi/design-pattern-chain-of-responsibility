package com.learning.pattern.chain.conta.controllers;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;
import com.learning.pattern.chain.conta.resposta.impl.ErrorResponse;
import com.learning.pattern.chain.conta.resposta.impl.CsvResponse;
import com.learning.pattern.chain.conta.resposta.impl.PercentResponse;
import com.learning.pattern.chain.conta.resposta.impl.XmlResponse;

public class ContaController {
    
    public void imprimeConta(Format format, Account account){
	
	Response erro = new ErrorResponse();
	Response porcento = new PercentResponse(erro);
	Response csv = new CsvResponse(porcento);
	Response xml = new XmlResponse(csv);
	
	Request request = new Request(format);
	xml.reply(request, account);
    }

}
