package com.khirata.chain.example.checkout.chain.service;

import com.khirata.chain.core.ChainProcessor;
import com.khirata.chain.core.Exchange;
import com.khirata.chain.core.Handler;
import com.khirata.chain.example.checkout.chain.domain.CheckoutExchangeData;
import com.khirata.chain.example.checkout.chain.domain.CheckoutRequest;
import com.khirata.chain.example.checkout.chain.domain.CheckoutResponse;
import com.khirata.chain.example.checkout.chain.domain.PaymentDetails;
import com.khirata.chain.example.checkout.chain.impl.OrderConfirmationHandler;
import com.khirata.chain.example.checkout.chain.impl.OrderCreationHandler;
import com.khirata.chain.example.checkout.chain.impl.ProcessPaymentHandler;
import com.khirata.chain.example.checkout.chain.impl.StockValidationHandler;

import java.util.List;

public class CheckoutService {

    public CheckoutResponse processCheckout(CheckoutRequest request) {

        CheckoutExchangeData checkoutData = new CheckoutExchangeData(request);

        List handlers = List.of(new StockValidationHandler(),
                                new ProcessPaymentHandler(),
                                new OrderCreationHandler(),
                                new OrderConfirmationHandler());

        ChainProcessor processor = new ChainProcessor<>(handlers);
        processor.process(new Exchange(checkoutData));

        return checkoutData.getResponse();
    }
}
