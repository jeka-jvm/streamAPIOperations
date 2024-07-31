package org.example.orderOperations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class OrderProcessor {

    public static List<Order> createOrders() {
        return List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
    }

    public static Map<String, List<Order>> groupByProduct(List<Order> orders) {
        Map<String, List<Order>> grouped = orders.stream()
                                                 .collect(Collectors.groupingBy(Order::getProduct));

        System.out.println("Группировка по продуктам:");
        grouped.forEach((product, orderList) -> System.out.println("Product: " + product + " -> " + orderList));

        return grouped;
    }

    public static Map<String, Double> calculateTotalCosts(Map<String, List<Order>> groupedOrders) {
        Map<String, Double> totalCosts = groupedOrders.entrySet()
                                                      .stream()
                                                      .collect(Collectors.toMap(
                                                              Map.Entry::getKey,
                                                              entry -> entry.getValue()
                                                                            .stream()
                                                                            .mapToDouble(Order::getCost)
                                                                            .sum()
                                                      ));

        System.out.println("Общая стоимость по продуктам:");
        totalCosts.forEach((product, totalCost) -> System.out.println("Product: " + product + " -> Total Cost: " + totalCost));

        return totalCosts;
    }

    public static List<Map.Entry<String, Double>> sortByTotalCost(Map<String, Double> totalCosts) {
        List<Map.Entry<String, Double>> sorted = totalCosts.entrySet()
                                                           .stream()
                                                           .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                                                           .collect(Collectors.toList());

        System.out.println("Сортировка по общей стоимости:");
        sorted.forEach(entry -> System.out.println("Product: " + entry.getKey() + " -> Total Cost: " + entry.getValue()));

        return sorted;
    }

    public static List<Map.Entry<String, Double>> getTopThreeProducts(List<Map.Entry<String, Double>> sortedTotalCosts) {
        return sortedTotalCosts.stream()
                               .limit(3)
                               .collect(Collectors.toList());
    }

    public static void printTopThreeProducts(List<Map.Entry<String, Double>> topThreeProducts) {
        System.out.println("Топ 3 самых дорогих продуктов:");
        topThreeProducts.forEach(entry -> System.out.println("Product: " + entry.getKey() + ", Total Cost: " + entry.getValue()));
    }

}
