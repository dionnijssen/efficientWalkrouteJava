package Logic.Rules;

import DataLayer.OrderruleRepository;
import DataLayer.ShoppinglistRepository;
import Logic.Controllers.OrderManager;
import Logic.Models.Article;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public class MinimumAmountRule extends BasicRule {
    private int amount;
    private String reason = null;
    private int minimumAmount;

    public MinimumAmountRule(Shoppinglist shoppingList, Article article, int minimumAmount) {
        super(shoppingList, article);

        this.minimumAmount = minimumAmount;
    }

    @Override
    public void apply() {
        if (this.amount >= this.minimumAmount) {
            this.applied = false;
            this.reason = "Success";

            return;
        }

        this.applied = true;
        this.reason = "Minimum amount raised to minimum amount of " + this.minimumAmount;
    }

    public boolean hasBeenApplied() {
        return this.applied;
    }

    @Override
    public String getReason() {
        return "Test";
    }

    @Override
    public void updateOrderrule() {
//        // Get Orderrule and change amount to minimum amount
//        for (Order order : this.shoppingList.getOrders()) {
//            for (Orderrule orderrule : order.getOrderrules()) {
//                if (orderrule.getArticle().getId() == this.article.getId()) {
//                    orderrule.setAmount(this.minimumAmount);
//                    new OrderruleRepository().update(orderrule);
//                    new OrderManager().updateOrder(order);
//
//                    return;
//                }
//            }
//        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
