package com.khirata.chain.core.handler.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;

public class SayHelloHandler implements Handler {

    @Override
    public void handle(Exchange exchange) throws Exception {
        System.out.println("Hello " + exchange.getData().toString());
    }
}
