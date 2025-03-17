# Design Pattern Chain Of Responsibility

The chain of responsibility pattern is great for keeping the code organized, maintaining small, single-responsibility classes, and making testing easier.

In general terms, to implement this pattern, we need to identify the different responsibilities in the code and separate them into handlers that follow a defined structure (interface).

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

## Using a loop 

To have both implementations in the repository, I duplicated all the discount code into the `loop` package, including the tests.

Then, I ran the tests to ensure everything was working before I apply the changes.

I started by removing the next Discount dependency from the Discount inteface. 

```java
public interface Discount {
    
    double calculateDiscount(PriceEstimate priceEstimate);
    
}
```

The next step is to adjust the implementations.Here is one example:
```java
public class MoreThanFiveItemsDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        if (priceEstimate.getItens().size() > 5) {
            return priceEstimate.getPrice() * 0.1;
        }
        return 0.0;
    }
}
```
In the controller, I created a list of handlers, and executed them in a `for` loop.

```java
public class DiscountCalculator {

    public double calc(PriceEstimate priceEstimate) {
        Discount d1 = new MoreThanFiveItemsDiscount();
        Discount d2 = new MoreThanFiveHundredDollarsDiscount();
        Discount d3 = new BundlingDiscount();
        Discount d4 = new NoDiscount();

        List<Discount> discountList= Arrays.asList(d1, d2, d3, d4);

        double totalDiscount = 0.0;

        for (Discount discount: discountList) {
            totalDiscount += discount.calculateDiscount(priceEstimate);
        }

        return totalDiscount;
    }
}
```
After running the tests again, everything worked as expected.

This way, we have a cleaner code, and the handlers does not have the responsibility of calling the next handler.