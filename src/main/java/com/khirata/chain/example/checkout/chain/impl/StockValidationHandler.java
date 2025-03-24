package com.khirata.chain.example.checkout.chain.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;
import com.khirata.chain.example.checkout.chain.domain.CheckoutExchangeData;
import com.khirata.chain.example.checkout.chain.domain.CheckoutResponse;

public class StockValidationHandler implements Handler<CheckoutExchangeData> {

    @Override
    public void handle(Exchange<CheckoutExchangeData> exchange) throws Exception {
        // Simulating stock validation
        System.out.println("[step 1] starting stock validation..");

        try {
            System.out.println(" - calling stock api.. ");
        } catch (Exception ex) {
            exchange.getData().setResponse(new CheckoutResponse("error", "Stock unavailable for some items!"));
            exchange.stopProcessing();
        }

        System.out.println("[step 1] finishing stock validation..");
    }
}
