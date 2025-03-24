package com.khirata.chain.example.checkout.chain.domain;

public class CheckoutExchangeData {

    private CheckoutRequest request;
    private CheckoutResponse response;
    private boolean stockValid;
    private String orderID;

    public CheckoutExchangeData(CheckoutRequest request, CheckoutResponse response) {
        this.request = request;
        this.response = response;
    }

    public CheckoutExchangeData(CheckoutRequest request) {
        this.request = request;
    }

    public CheckoutRequest getRequest() {
        return request;
    }

    public void setRequest(CheckoutRequest request) {
        this.request = request;
    }

    public CheckoutResponse getResponse() {
        return response;
    }

    public void setResponse(CheckoutResponse response) {
        this.response = response;
    }

    public boolean isStockValid() {
        return stockValid;
    }

    public void setStockValid(boolean stockValid) {
        this.stockValid = stockValid;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
