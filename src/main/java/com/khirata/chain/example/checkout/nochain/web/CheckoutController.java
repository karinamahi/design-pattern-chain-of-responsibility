package com.khirata.chain.example.checkout.nochain.web;

import com.khirata.chain.example.checkout.nochain.domain.CheckoutRequest;
import com.khirata.chain.example.checkout.nochain.domain.CheckoutResponse;
import com.khirata.chain.example.checkout.nochain.service.CheckoutService;

public class CheckoutController {

    private final CheckoutService checkoutService;


    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService= checkoutService;
    }

    public CheckoutResponse checkout(CheckoutRequest request) {
        return checkoutService.processCheckout(request);
    }
}
