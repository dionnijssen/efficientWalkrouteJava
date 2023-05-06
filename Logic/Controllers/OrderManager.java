package Logic.Controllers;

import DataLayer.ArticleRepository;
import DataLayer.ShoppinglistRepository;
import Logic.Interfaces.OrderManagerInterface;
import Logic.Models.Article;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

import java.util.ArrayList;

public class OrderManager implements OrderManagerInterface {

    private ShoppinglistRepository shoppinglistRepository;
    private ArticleRepository articleRepository;

    public OrderManager(ShoppinglistRepository shoppinglistRepository, ArticleRepository articleRepository) {
        this.shoppinglistRepository = shoppinglistRepository;
        this.articleRepository = articleRepository;
    }

    public Order addToOrder(Order order, Orderrule orderrule) {
//        if (order.orderrules == null) {
//            ArrayList<Orderrule> orderrules = new ArrayList<Orderrule>();
//            orderrules.add(orderrule);
//            order.orderrules = orderrules;
//        } else {
        order.orderrules.add(orderrule);
//        }

        return order;
    }

    public boolean storeOrder(Shoppinglist shoppinglist, Order order) {
        try {
            for (Shoppinglist list : this.shoppinglistRepository.get()) {
                if (list.id == shoppinglist.id) {
                    if (shoppinglist.orders == null) {
                        ArrayList<Order> orders = new ArrayList<Order>();
                        orders.add(order);
                        shoppinglist.orders = orders;
                    } else {
                        shoppinglist.orders.add(order);
                    }
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Shoppinglist addOrderToShoppingList(Shoppinglist shoppinglist, Order order) {
        if (shoppinglist.orders == null) {
            ArrayList<Order> orders = new ArrayList<Order>();
            orders.add(order);
            shoppinglist.orders = orders;
        } else {
            shoppinglist.orders.add(order);
        }
        Shoppinglist updatedShoppingList = this.shoppinglistRepository.update(shoppinglist);

        if (updatedShoppingList != null) {
            System.out.println("Order added to shoppinglist");

            return updatedShoppingList;
        } else {
            System.out.println("Something went wrong, please try again");

            throw new RuntimeException("Something went wrong, please try again");
        }
    }

    public boolean removeFromOrder(Order order, Article article, int amount) {
        return false;
    }
}
