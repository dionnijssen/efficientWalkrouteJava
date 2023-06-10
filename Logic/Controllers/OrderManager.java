package Logic.Controllers;

import DataLayer.ArticleRepository;
import DataLayer.ShoppinglistRepository;
import Logic.Interfaces.Logic.Controllers.OrderManagerInterface;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public class OrderManager implements OrderManagerInterface {

    private ShoppinglistRepository shoppinglistRepository;
    private ArticleRepository articleRepository;

    public OrderManager(ShoppinglistRepository shoppinglistRepository, ArticleRepository articleRepository) {
        this.shoppinglistRepository = shoppinglistRepository;
        this.articleRepository = articleRepository;
    }

    public Order addToOrder(Order order, Orderrule orderrule) {
        order.getOrderrules().add(orderrule);

        return order;
    }

    public Order removeFromOrder(Order order, Orderrule orderrule) {
        order.getOrderrules().remove(orderrule);

        return order;
    }

    public boolean storeOrder(Shoppinglist shoppinglist, Order order) {
        try {
            for (Shoppinglist list : this.shoppinglistRepository.get()) {
                if (list.getId() == shoppinglist.getId()) {
                    shoppinglist.addOrder(order);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Shoppinglist addOrderToShoppingList(Shoppinglist shoppinglist, Order order) {
        shoppinglist.addOrder(order);
        Shoppinglist updatedShoppingList = this.shoppinglistRepository.update(shoppinglist);

        if (updatedShoppingList != null) {
            System.out.println("Order added to shoppinglist");

            return updatedShoppingList;
        } else {
            System.out.println("Something went wrong, please try again");

            throw new RuntimeException("Something went wrong, please try again");
        }
    }
}
