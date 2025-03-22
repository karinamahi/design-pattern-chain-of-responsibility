package com.khirata.chain.core;

public interface Handler<T> {

    void handle(Exchange<T> exchange) throws Exception;
}