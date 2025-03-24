package com.khirata.chain.example.checkout.chain.web;

import com.khirata.chain.example.checkout.chain.domain.CheckoutRequest;
import com.khirata.chain.example.checkout.chain.domain.CheckoutResponse;
import com.khirata.chain.example.checkout.chain.service.CheckoutService;

public class CheckoutController {

    private final CheckoutService checkoutService;


    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService= checkoutService;
    }

    public CheckoutResponse checkout(CheckoutRequest request) {
        return checkoutService.processCheckout(request);
    }
}
