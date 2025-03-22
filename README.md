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

The next step is to adjust the implementations. Here is one example:
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

## Checkout Example

I created a simplified version of a real-world checkout process without using Chain of Responsibility pattern. This way, we will have both implementations to compare.

Our checkout process will simulate the following steps:
- Stock validation
- Payment processing
- Order creation
- Post-checkout actions (sending a email notifying the customer)

```java
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
    ...
```

### Creating a generic and reusable Chain of Responsibility structure

It may be interesting to create a reusable structure and a common library for our projects. This can be implemented in various ways, here is one example.

First, I created defined a generic `Handler` that processes an object of type `Exchange`. The `Exchange` class encapsulate a generic `data`, and can include other useful features for the data processing. In this example, we use a `stop` flag to help the processor halt the execution.

```java
public interface Handler<T> {
    
    void handle(Exchange<T> exchange) throws Exception;
}

public class Exchange<T> {

    private T data;
    private boolean stop = false;

    public Exchange(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean shouldStop() {
        return stop;
    }

    public void stopProcessing() {
        this.stop = true;
    }
}
```

The, I created a generic chain processor that hold all the handlers and is responsible for execute them.

```java
public class ChainProcessor<T> {
    
    private final List<Handler<T>> handlers;

    public ChainProcessor(List<Handler<T>> handlers) {
        this.handlers = handlers;
    }

    public void process(Exchange<T> exchange) {
        for (Handler<T> handler : handlers) {
            if (exchange.shouldStop()) {
                System.out.println("Processing stopped due to an error.");
                break;
            }

            try {
                handler.handle(exchange);
            } catch (Exception e) {
                System.out.println("Error in handler: " + e.getMessage());
                exchange.stopProcessing(); // Stop further processing
            }
        }
    }
}
```
Now, our reusable chain library is ready to use. We just need to implement the handlers according to the desired rules and instantiate a processor to execute them. So, let's test it!

```java
// handlers
public class PrintDataHandler implements Handler {
    @Override
    public void handle(Exchange exchange) {
        System.out.println("Printing data " + exchange.getData().toString());
    }
}

public class SayHelloHandler implements Handler {

    @Override
    public void handle(Exchange exchange) throws Exception {
        System.out.println("Hello " + exchange.getData().toString());
    }
}

public class SayGoodByeHandler implements Handler {

    @Override
    public void handle(Exchange exchange) throws Exception {
        System.out.println("Good bye " + exchange.getData().toString());
    }
}

public class ErrorExampleHandler implements Handler {
    @Override
    public void handle(Exchange exchange) throws Exception {
        System.out.println("Oops");
        exchange.stopProcessing();
        throw new Exception("Oops Exception");
    }
}

// processor
    @Test
    public void processTest() {

        List handlers = List.of(new PrintDataHandler(),
                new SayHelloHandler(),
                new ErrorExampleHandler(),
                new SayGoodByeHandler());

        ChainProcessor processor = new ChainProcessor<>(handlers);
        processor.process(new Exchange("World"));
    }
    
```
In this test, I'm simulating an error, and the chain processing stops as expected:

```text
Printing data World
Hello World
Oops
Error in handler: Oops Exception
Processing stopped due to an error.
```