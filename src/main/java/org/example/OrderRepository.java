package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private Map<String, Order> orders;

    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    public Order getOrderById(String id) {
        return orders.get(id);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

}
