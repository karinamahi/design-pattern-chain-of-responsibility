package com.khirata.chain.example.checkout.chain.impl;

import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;
import com.khirata.chain.example.checkout.chain.domain.CheckoutExchangeData;
import com.khirata.chain.example.checkout.chain.domain.CheckoutResponse;

public class OrderCreationHandler implements Handler<CheckoutExchangeData> {

    @Override
    public void handle(Exchange<CheckoutExchangeData> exchange) throws Exception {
        // Simulating order creation
        System.out.println("[step 3] starting order creation..");
        System.out.println(" - calling order api.. ");
        String orderID = "ORD-" + System.currentTimeMillis();
        exchange.getData().setOrderID(orderID);
        exchange.getData().setResponse(new CheckoutResponse("success", "Order placed successfully! Order ID: " + orderID));
        System.out.println("[step 3] finishing order creation..");
    }
}
