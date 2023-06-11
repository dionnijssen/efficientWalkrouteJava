package DataLayer;

import Logic.Interfaces.Data.RepositoryInterface;
import Logic.Models.Order;

import java.util.ArrayList;

public class OrderRepository implements RepositoryInterface<Order> {
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

    public Order update(Order order) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getId() == order.getId()) {
                this.orders.set(i, order);
                return order;
            }
        }

        return null;
    }

    public boolean delete(Order order) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getId() == order.getId()) {
                this.orders.remove(i);
                return true;
            }
        }

        return false;
    }
}
