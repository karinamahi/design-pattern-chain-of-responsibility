# Design Pattern Chain Of Responsibility

## Basic Implementation

In this simple implementation, we created an interface to define what each discount handler must include:
- a method to calculate the discount
- the next handler

```java
public interface Discount {

    double calculateDiscount(PriceEstimate priceEstimate);

    void setDiscount(Discount next);
}
```

In the controller, we have all the discount handlers linked in a chain, as each handler has a reference to the next one.
```java
public class DiscountCalculator {

    public double calc(PriceEstimate priceEstimate) {
        Discount d1 = new MoreThanFiveItemsDiscount();
        Discount d2 = new MoreThanFiveHundredDollarsDiscount();
        Discount d3 = new BundlingDiscount();
        Discount d4 = new NoDiscount();

        d1.setDiscount(d2);
        d2.setDiscount(d3);
        d3.setDiscount(d4);

        return d1.calculateDiscount(priceEstimate);
    }
}

```

Each handler is responsible for applying its own rules and/or calling the next handler.
```java
public class MoreThanFiveItemsDiscount implements Discount {

    private Discount next;

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getItens().size() > 5) {
            return priceEstimate.getPrice() * 0.1;
        }
        return next.calculateDiscount(priceEstimate);
    }

    public void setDiscount(Discount next) {
        this.next = next;
    }
}
```

This is an easy way to understand the idea behind the Chain of Responsibility pattern. However, as we can see, each handler still has some knowledge of the next handler. This is something we can improve in future implementations.
