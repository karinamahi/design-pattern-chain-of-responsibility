package com.khirata.chain.basic.discount.controllers;

import com.khirata.chain.basic.discount.models.Item;
import com.khirata.chain.basic.discount.models.PriceEstimate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DiscountCalculatorTest {

    private DiscountCalculator calculator;

    @BeforeClass
    public void init() {
        this.calculator = new DiscountCalculator();
    }

    @Test
    public void calculateDiscountTest() {
        PriceEstimate priceEstimate = new PriceEstimate(500.0);
        priceEstimate.addItem(new Item("pen", 250.0));
        priceEstimate.addItem(new Item("book", 250.0));
        double discount = this.calculator.calc(priceEstimate);
        Assert.assertEquals(discount, 0.0);
        System.out.println("Discount: " + discount);
    }

    @Test
    public void moreThanFiveItemsDiscountTest() {
        PriceEstimate priceEstimate = new PriceEstimate(500.0);
        priceEstimate.addItem(new Item("pen", 50.0));
        priceEstimate.addItem(new Item("book", 50.0));
        priceEstimate.addItem(new Item("notebook", 50.0));
        priceEstimate.addItem(new Item("sharpener", 50.0));
        priceEstimate.addItem(new Item("scissors", 50.0));
        priceEstimate.addItem(new Item("ruler", 50.0));
        double discount = this.calculator.calc(priceEstimate);
        System.out.println("Discount: " + discount);
        Assert.assertTrue(discount > 0);
    }

    @Test
    public void moreThanFiveHundredDollarsDiscountTest() {
        PriceEstimate priceEstimate = new PriceEstimate(600.0);
        priceEstimate.addItem(new Item("pen", 50.0));
        priceEstimate.addItem(new Item("notebook", 50.0));
        double discount = this.calculator.calc(priceEstimate);
        System.out.println("Discount: " + discount);
        Assert.assertTrue(discount > 0);
    }

    @Test
    public void bundlingDiscountTest() {
        PriceEstimate priceEstimate = new PriceEstimate(500.0);
        priceEstimate.addItem(new Item("pen", 10.0));
        priceEstimate.addItem(new Item("pencil", 10.0));
        double discount = this.calculator.calc(priceEstimate);
        System.out.println("Discount: " + discount);
        Assert.assertTrue(discount > 0);
    }
}
