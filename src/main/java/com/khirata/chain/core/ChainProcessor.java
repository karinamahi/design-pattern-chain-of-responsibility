package com.khirata.chain.core;

import java.util.List;

public class ChainProcessor<T> {

    private final List<Handler<T>> handlers;

    public ChainProcessor(List<Handler<T>> handlers) {
        this.handlers = handlers;
    }

    public void process(Exchange<T> exchange) {
        for (Handler<T> handler : handlers) {
            if (exchange.shouldStop()) {
                System.out.println("Processing stopped due to an error.");
                break;
            }

            try {
                handler.handle(exchange);
            } catch (Exception e) {
                System.out.println("Error in handler: " + e.getMessage());
                exchange.stopProcessing(); // Stop further processing
            }
        }
    }
}

