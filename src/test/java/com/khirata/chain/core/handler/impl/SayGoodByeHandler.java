package com.khirata.chain.core.handler.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;

public class SayGoodByeHandler implements Handler {

    @Override
    public void handle(Exchange exchange) throws Exception {
        System.out.println("Good bye " + exchange.getData().toString());
    }
}
