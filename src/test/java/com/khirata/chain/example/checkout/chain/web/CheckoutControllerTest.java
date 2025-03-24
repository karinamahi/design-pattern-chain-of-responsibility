package com.khirata.chain.example.checkout.chain.web;

import com.khirata.chain.example.checkout.chain.domain.CheckoutRequest;
import com.khirata.chain.example.checkout.chain.domain.CheckoutResponse;
import com.khirata.chain.example.checkout.chain.domain.PaymentDetails;
import com.khirata.chain.example.checkout.chain.service.CheckoutService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CheckoutControllerTest {

    @Test
    public void checkoutTest() {
        CheckoutService checkoutService = new CheckoutService();
        CheckoutController checkoutController = new CheckoutController(checkoutService);

        PaymentDetails paymentDetails = new PaymentDetails();

        CheckoutRequest request = new CheckoutRequest();
        request.setPaymentDetails(paymentDetails);
        request.setCartItems(new ArrayList<>());

        CheckoutResponse response = checkoutController.checkout(request);
        Assert.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }
}
