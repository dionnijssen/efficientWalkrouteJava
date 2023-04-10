package Logic.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    public int id;
    private LocalDate date;
    public ArrayList<Orderrule> orderrules;

    public Order(int id, LocalDate date, ArrayList<Orderrule> orderrules) {
        this.id = id;
        this.date = date;
        this.orderrules = orderrules;
    }
}
