package Logic.Controllers;

import DataLayer.ShoppinglistRepository;
import Logic.Interfaces.Logic.Controllers.OrderManagerInterface;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public class OrderManager implements OrderManagerInterface {

    private ShoppinglistRepository shoppinglistRepository;

    public OrderManager(ShoppinglistRepository shoppinglistRepository) {
        this.shoppinglistRepository = shoppinglistRepository;
    }

    public Order addToOrder(Order order, Orderrule orderrule) {
        order.getOrderrules().add(orderrule);

        return order;
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
