package Logic.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Shoppinglist {
    public int id;
    //TODO: Check if this needs to be private
    public LocalDate date;
    public ArrayList<Order> orders;
    private WalkRoute walkRoute;

    public Shoppinglist(int id, LocalDate date, ArrayList<Order> orders, WalkRoute walkRoute) {
        this.id = id;
        this.date = date;
        this.orders = orders;
        this.walkRoute = walkRoute;
    }
}
