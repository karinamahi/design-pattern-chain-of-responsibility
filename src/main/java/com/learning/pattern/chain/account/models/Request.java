package com.learning.pattern.chain.account.models;

public class Request {

    private Format format;

    public Request(Format format) {
        super();
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }
}
