package Logic.Models;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Orderrule> orderrules;

    public Order(int id, ArrayList<Orderrule> orderrules) {
        this.id = id;
        this.orderrules = orderrules;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Orderrule> getOrderrules() {
        return this.orderrules;
    }
}
