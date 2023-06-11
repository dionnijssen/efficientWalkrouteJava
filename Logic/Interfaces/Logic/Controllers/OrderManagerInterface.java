package Logic.Interfaces.Logic.Controllers;

import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public interface OrderManagerInterface {
    Order addToOrder(Order order, Orderrule orderrule);

    Shoppinglist addOrderToShoppingList(Shoppinglist shoppinglist, Order order);
}
