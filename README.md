# Практическое задание - Stream API - генерация чисел
## Описание
Предположим, у нас есть список заказов, и каждый заказ представляет собой продукт и его стоимость. Задача состоит в использовании Stream API и коллекторов для решения следующих задач:
- Создайте список заказов с разными продуктами и их стоимостями.
- Группируйте заказы по продуктам.
- Для каждого продукта найдите общую стоимость всех заказов.
- Отсортируйте продукты по убыванию общей стоимости.
- Выберите три самых дорогих продукта.
- Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
## Исходный код
```java
class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }
}

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
}
```
## Технологический стек:
- *Java 17*
- *Maven*
