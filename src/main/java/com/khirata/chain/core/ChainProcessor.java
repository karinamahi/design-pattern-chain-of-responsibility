package com.khirata.chain.core;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ChainProcessor<T> {

    private final List<Handler<T>> handlers;
    private final List<String> logs = new ArrayList<>();

    public ChainProcessor(List<Handler<T>> handlers) {
        this.handlers = handlers;
    }

    public void process(Exchange<T> exchange) {
        for (Handler<T> handler : handlers) {

            Instant start = Instant.now();
            int stepNumber = handlers.indexOf(handler);
            String handlerName = handler.getClass().getSimpleName();

            if (exchange.shouldStop()) {
                System.out.println("Processing stopped due to an error.");
                logs.add(generateLogMessage(stepNumber, "SKIPPED", handlerName, start));
                continue;
            }

            try {
                handler.handle(exchange);
                logs.add(generateLogMessage(stepNumber, "EXECUTED", handlerName, start));
            } catch (Exception e) {
                System.out.println("Error in handler: " + e.getMessage());
                exchange.stopProcessing(); // Stop further processing
                logs.add(generateLogMessage(stepNumber, "ERROR", handlerName, start));
            }
        }
        printReport();
    }

    private static String generateLogMessage(int stepNumber, String status, String handlerName, Instant start) {
        return "[Step " + stepNumber + "][" + status + "] "+ handlerName + " - Execution time: " + Duration.between(start, Instant.now()).toMillis() + " ms.";
    }

    private void printReport() {
        System.out.println("\n=================== Execution Report ====================");
        logs.forEach(System.out::println);
        System.out.println("=========================================================");
    }
}

