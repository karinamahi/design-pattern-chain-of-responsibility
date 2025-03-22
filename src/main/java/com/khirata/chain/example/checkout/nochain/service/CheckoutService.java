package com.khirata.chain.example.checkout.nochain.service;

import com.khirata.chain.example.checkout.nochain.domain.CheckoutRequest;
import com.khirata.chain.example.checkout.nochain.domain.CheckoutResponse;
import com.khirata.chain.example.checkout.nochain.domain.PaymentDetails;

public class CheckoutService {

    public CheckoutResponse processCheckout(CheckoutRequest request) {

        // Step 1: Validate cart items and stock availability
        if (!validateStock(request)) {
            return new CheckoutResponse("error", "Stock unavailable for some items!");
        }

        // Step 2: Process payment
        processPayment(request.getPaymentDetails());

        // Step 3: Create order
        String orderId = createOrder(request);

        // Step 4: Send order confirmation (simulated)
        sendOrderConfirmation(request.getUserId(), orderId);

        return new CheckoutResponse("success", "Order placed successfully! Order ID: " + orderId);
    }

    private boolean validateStock(CheckoutRequest request) {
        // Simulating stock validation
        System.out.println("[step 1] starting stock validation..");
        System.out.println(" - calling stock api.. ");
        System.out.println("[step 1] finishing stock validation..");
        return true; // Assume all items are available
    }

    private void processPayment(PaymentDetails paymentDetails) {
        // Simulating payment processing
        System.out.println("[step 2] starting payment processing..");
        System.out.println(" - calling payment api.. ");
        System.out.println("[step 2] async process - payment will be processed..");
    }

    private String createOrder(CheckoutRequest request) {
        // Simulating order creation
        System.out.println("[step 3] starting order creation..");
        System.out.println(" - calling order api.. ");
        System.out.println("[step 3] finishing order creation..");
        return "ORD-" + System.currentTimeMillis();
    }

    private void sendOrderConfirmation(String userId, String orderId) {
        // Simulating order confirmation
        System.out.println("[step 4] starting order confirmation process..");
        System.out.println(" - calling user notification api.. ");
        System.out.println("[step 4] async process - user notification will be processed..");
    }
}
