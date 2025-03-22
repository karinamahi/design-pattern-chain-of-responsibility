package com.khirata.nochain.checkout.web;

import com.khirata.nochain.checkout.domain.CheckoutRequest;
import com.khirata.nochain.checkout.domain.CheckoutResponse;
import com.khirata.nochain.checkout.service.CheckoutService;

public class CheckoutController {

    private final CheckoutService checkoutService;


    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService= checkoutService;
    }

    public CheckoutResponse checkout(CheckoutRequest request) {
        return checkoutService.processCheckout(request);
    }
}
