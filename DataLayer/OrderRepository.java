package DataLayer;

import DataLayer.Interfaces.RepositoryInterface;
import Logic.Models.Order;

import java.util.ArrayList;

public class OrderRepository implements RepositoryInterface<Order> {
    private final ArrayList<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<Order>();

//        ArrayList<Order> orders = new ArrayList<>();
//        ArrayList<Orderrule> orderrules = new ArrayList<Orderrule>();
//
//        orders.add(
//                new Order(
//                        1,
//                        LocalDate.now(),
//                        orderrules
//                ));
//
//        orders.add(
//                new Order(
//                        2,
//                        LocalDate.now(),
//                        orderrules
//                ));
//
//        orders.add(
//                new Order(
//                        3,
//                        LocalDate.now(),
//                        orderrules
//                ));
    }

    public ArrayList<Order> get() {
        return this.orders;
    }

    public Order show(int id) {
        for (Order order : (get())) {
            if (order.id == id) {
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
            if (this.orders.get(i).id == order.id) {
                this.orders.set(i, order);
                return order;
            }
        }

        return null;
    }

    public boolean delete(Order order) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).id == order.id) {
                this.orders.remove(i);
                return true;
            }
        }

        return false;
    }
}
