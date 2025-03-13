package com.learning.pattern.chain.conta.controllers;

import com.learning.pattern.chain.conta.models.Account;
import com.learning.pattern.chain.conta.models.Format;
import com.learning.pattern.chain.conta.models.Request;
import com.learning.pattern.chain.conta.resposta.Resposta;
import com.learning.pattern.chain.conta.resposta.impl.RespostaDeErro;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmCsv;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmPorcento;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmXml;

public class ContaController {
    
    public void imprimeConta(Format format, Account account){
	
	Resposta erro = new RespostaDeErro();
	Resposta porcento = new RespostaEmPorcento(erro);
	Resposta csv = new RespostaEmCsv(porcento);
	Resposta xml = new RespostaEmXml(csv);
	
	Request request = new Request(format);
	xml.responde(request, account);
    }

}
