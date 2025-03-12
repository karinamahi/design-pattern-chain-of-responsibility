package com.learning.pattern.chain.conta.models;

public class Requisicao {

    private Format format;

    public Requisicao(Format format) {
	super();
	this.format = format;
    }

    public Format getFormato() {
        return format;
    }
}
