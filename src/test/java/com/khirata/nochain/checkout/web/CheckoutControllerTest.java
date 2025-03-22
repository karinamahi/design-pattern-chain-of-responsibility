package com.khirata.nochain.checkout.web;

import com.khirata.nochain.checkout.domain.CheckoutRequest;
import com.khirata.nochain.checkout.domain.CheckoutResponse;
import com.khirata.nochain.checkout.domain.PaymentDetails;
import com.khirata.nochain.checkout.service.CheckoutService;
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
