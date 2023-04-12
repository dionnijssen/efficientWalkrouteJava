package Logic.Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    public int id;
    public ArrayList<Orderrule> orderrules;
    private LocalDate date;

    public Order(int id, LocalDate date, ArrayList<Orderrule> orderrules) {
        this.id = id;
        this.date = date;
        this.orderrules = orderrules;
    }
}
