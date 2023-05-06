package Logic.Interfaces;

import Logic.Models.Article;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public interface OrderManagerInterface {
    Order addToOrder(Order order, Orderrule orderrule);

    boolean storeOrder(Shoppinglist shoppinglist, Order order);

    boolean removeFromOrder(Order order, Article article, int amount);
}
