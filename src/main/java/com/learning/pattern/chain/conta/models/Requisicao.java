package com.learning.pattern.chain.conta.models;

public class Requisicao {

    private Formato formato;

    public Requisicao(Formato formato) {
	super();
	this.formato = formato;
    }

    public Formato getFormato() {
        return formato;
    }
}
