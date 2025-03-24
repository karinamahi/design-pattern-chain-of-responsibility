package com.khirata.chain.core.handler.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;

public class ErrorExampleHandler implements Handler {
    @Override
    public void handle(Exchange exchange) throws Exception {
        System.out.println("Oops");
        exchange.stopProcessing();
        throw new Exception("Oops Exception");
    }
}
