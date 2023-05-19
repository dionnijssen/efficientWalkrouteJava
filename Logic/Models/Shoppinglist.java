package Logic.Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Shoppinglist {
    private int id;
    //TODO: Check if this needs to be private
    private LocalDate date;
    private ArrayList<Order> orders;
    private WalkRoute walkRoute;

    public Shoppinglist(int id, LocalDate date, ArrayList<Order> orders, WalkRoute walkRoute) {
        this.id = id;
        this.date = date;
        this.orders = orders;
        this.walkRoute = walkRoute;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public boolean addOrder(Order order) {
        if (this.orders == null) {
            this.orders = new ArrayList<Order>();
        }

        return this.orders.add(order);
    }
}
