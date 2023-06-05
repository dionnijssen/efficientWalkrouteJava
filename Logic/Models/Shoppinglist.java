package Logic.Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Shoppinglist {
    private int id;
    private LocalDate date;
    private ArrayList<Order> orders;
    private int walkRouteId;

    public Shoppinglist(int id, LocalDate date, ArrayList<Order> orders, WalkRoute walkRoute) {
        this.id = id;
        this.date = date;
        this.orders = orders;
        this.walkRouteId = walkRouteId;
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

    public boolean setWalkRouteId(int walkRouteId) {
        this.walkRouteId = walkRouteId;
        return true;
    }

    public int getWalkRouteId() {
        return this.walkRouteId;
    }
}
