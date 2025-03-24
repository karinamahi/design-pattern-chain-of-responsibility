package com.khirata.chain.example.checkout.chain.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;
import com.khirata.chain.example.checkout.chain.domain.CheckoutExchangeData;
import com.khirata.chain.example.checkout.chain.domain.CheckoutResponse;

public class OrderConfirmationHandler implements Handler<CheckoutExchangeData> {

    @Override
    public void handle(Exchange<CheckoutExchangeData> exchange) throws Exception {
        System.out.println("[step 4] starting order confirmation process..");
        System.out.println(" - calling user notification api.. ");
        System.out.println("[step 4] async process - user notification will be processed..");
    }
}
