package org.example;

import org.example.orderOperations.Order;
import org.example.orderOperations.OrderProcessor;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        // Создаём список заказов
        List<Order> orders = OrderProcessor.createOrders();

        // Группируем заказы по продукту
        Map<String, List<Order>> groupedOrders = OrderProcessor.groupByProduct(orders);

        // Вычисляем общую стоимость заказов по продуктам
        Map<String, Double> totalCosts = OrderProcessor.calculateTotalCosts(groupedOrders);

        // Сортируем по возрастанию стоимости заказов
        List<Map.Entry<String, Double>> sortedTotalCosts = OrderProcessor.sortByTotalCost(totalCosts);

        // Получаем топ-3 продуктов
        List<Map.Entry<String, Double>> topThreeProducts = OrderProcessor.getTopThreeProducts(sortedTotalCosts);

        // Показываем топ-3 продуктов в консоль
        OrderProcessor.printTopThreeProducts(topThreeProducts);
    }
}