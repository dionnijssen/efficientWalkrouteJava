package DataLayer;

import Logic.Models.Order;

import java.util.ArrayList;

public class OrderRepository {
    private final ArrayList<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<Order>();
    }

    public ArrayList<Order> get() {
        return this.orders;
    }

    public Order show(int id) {
        for (Order order : (get())) {
            if (order.getId() == id) {
                return order;
            }
        }

        return null;
    }

    public Order store(Order order) {
        this.orders.add(order);

        return order;
    }
}
