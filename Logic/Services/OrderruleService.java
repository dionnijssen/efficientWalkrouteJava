package Logic.Services;

import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public class OrderruleService {
    public Orderrule getOrderrule(Shoppinglist shoppinglist, int articleId) {
        for (Order order : shoppinglist.getOrders()) {
            for (Orderrule orderrule : order.getOrderrules()) {
                if (orderrule.getArticle().getId() == articleId) {
                    return orderrule;
                }
            }
        }

        throw new IllegalArgumentException("Article not found in shoppinglist");
    }
}
