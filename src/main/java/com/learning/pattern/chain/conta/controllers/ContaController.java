package com.learning.pattern.chain.conta.controllers;

import com.learning.pattern.chain.conta.models.Conta;
import com.learning.pattern.chain.conta.models.Formato;
import com.learning.pattern.chain.conta.models.Requisicao;
import com.learning.pattern.chain.conta.resposta.Resposta;
import com.learning.pattern.chain.conta.resposta.impl.RespostaDeErro;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmCsv;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmPorcento;
import com.learning.pattern.chain.conta.resposta.impl.RespostaEmXml;

public class ContaController {
    
    public void imprimeConta(Formato formato, Conta conta){
	
	Resposta erro = new RespostaDeErro();
	Resposta porcento = new RespostaEmPorcento(erro);
	Resposta csv = new RespostaEmCsv(porcento);
	Resposta xml = new RespostaEmXml(csv);
	
	Requisicao requisicao = new Requisicao(formato);
	xml.responde(requisicao , conta);
    }

}
