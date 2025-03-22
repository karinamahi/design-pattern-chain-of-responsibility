package com.khirata.chain.core.handler.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;

public class PrintDataHandler implements Handler {
    @Override
    public void handle(Exchange exchange) {
        System.out.println("Printing data " + exchange.getData().toString());
    }
}
