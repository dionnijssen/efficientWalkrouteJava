package Logic.Interfaces;

import Logic.Models.Article;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

import java.io.IOException;

public interface OrderManagerInterface {
    Order addArticlesToOrder(Order order) throws IOException;

    Order addToOrder(Order order, Orderrule orderrule);

    boolean storeOrder(Shoppinglist shoppinglist, Order order);

    Shoppinglist addOrderToShoppingList(Shoppinglist shoppinglist, Order order);

    boolean removeFromOrder(Order order, Article article, int amount);
}
