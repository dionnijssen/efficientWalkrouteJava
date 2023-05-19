package Logic.Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Orderrule> orderrules;
    private LocalDate date;

    public Order(int id, LocalDate date, ArrayList<Orderrule> orderrules) {
        this.id = id;
        this.date = date;
        this.orderrules = orderrules;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Orderrule> getOrderrules() {
        return this.orderrules;
    }
}
