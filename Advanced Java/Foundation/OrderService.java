package Foundation;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class OrderService {

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("A1", 500, true),
                new Order("A2", 2000, false),
                new Order("A3", 1500, true),
                new Order("A4", 11000, true)
        );

        // 1️⃣ Predicate ( takes i/p, returns boolean) → filter only paid orders
        Predicate<Order> isPaid = order -> order.isPaid();

        // 2️⃣ Function( takes i/p, returns o/p) → transform Order to String summary
        Function<Order, String> orderSummary =
                order -> "OrderID: " + order.getId() +
                         ", Amount: " + order.getAmount();

        // 3️⃣ Consumer( takes i/p, returns nothing) → log result
        Consumer<String> logger =
                message -> System.out.println("LOG: " + message);

        // 4️⃣ Supplier( takes no o/p, reutrns a val) → default fallback message
        Supplier<String> emptyMessage =
                () -> "No valid orders found.";

        // Process pipeline (very real backend style)
        List<String> processedOrders = orders.stream()
                .filter(isPaid)          // use Predicate
                .map(orderSummary)       // use Function
                .collect(Collectors.toList());

        if (processedOrders.isEmpty()) {
            logger.accept(emptyMessage.get()); // use Supplier + Consumer
        } else {
            processedOrders.forEach(logger);  // use Consumer
        }

        // 5️⃣ RuntimeException example
        validateHighValueOrders(orders);
    }

    // Business validation logic
    private static void validateHighValueOrders(List<Order> orders) {
        orders.forEach(order -> {
            if (order.getAmount() > 10000) {
                throw new RuntimeException(
                        "High value order requires manual approval: " + order.getId()
                );
            }
        });
    }
}