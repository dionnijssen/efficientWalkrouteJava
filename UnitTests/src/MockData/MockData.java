package MockData;

import Logic.Models.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class MockData {
    public static Shoppinglist getShoppinglist() {
        Article article = new Article(1, "Test", "Test description");
        Order order = new Order(1, new ArrayList<Orderrule>() {{
            add(new Orderrule(article, 5));
        }});

        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(order);

        Shoppinglist shoppinglist = new Shoppinglist(1, LocalDate.now());

        shoppinglist.addOrder(order);

        return shoppinglist;
    }

    public static Orderrule getOrderrule() {
        Article article = new Article(1, "Test", "Test description");
        Orderrule orderrule = new Orderrule(article, 5);

        return orderrule;
    }
}
