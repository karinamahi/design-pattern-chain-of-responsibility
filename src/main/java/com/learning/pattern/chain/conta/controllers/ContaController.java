package com.learning.pattern.chain.conta.controllers;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Response;
import com.learning.pattern.chain.conta.resposta.impl.RespostaDeErro;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmCsv;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmPorcento;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmXml;

public class ContaController {
    
    public void imprimeConta(Format format, Account account){
	
	Response erro = new RespostaDeErro();
	Response porcento = new RespostaEmPorcento(erro);
	Response csv = new RespostaEmCsv(porcento);
	Response xml = new RespostaEmXml(csv);
	
	Request request = new Request(format);
	xml.reply(request, account);
    }

}
