package com.khirata.chain.example.checkout.chain.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;
import com.khirata.chain.example.checkout.chain.domain.CheckoutExchangeData;

public class ProcessPaymentHandler implements Handler<CheckoutExchangeData> {

    @Override
    public void handle(Exchange<CheckoutExchangeData> exchange) throws Exception {
        // Simulating payment processing
        System.out.println("[step 2] starting payment processing..");
        System.out.println(" - calling payment api.. ");
        System.out.println("[step 2] async process - payment will be processed..");
        throw new Exception("Payment API unavailable.");
    }
}
