package Logic.Services;

import DataLayer.ArticleRepository;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Rule;
import Logic.Models.Shoppinglist;
import Logic.Rules.MaximumAmountRule;
import Logic.Rules.MinimumAmountRule;

import java.util.ArrayList;

public class CreateWalkRouteService {
    public Boolean applyRules(ArrayList<Rule> activeRules, Shoppinglist shoppinglist) {
        Boolean success = true;
        for (Rule rule : activeRules) {
            //Todo refactor this into a mapper
            switch (rule.getType()) {
                case "min":
                    MinimumAmountRule minimumAmountRule = new MinimumAmountRule();

                    minimumAmountRule.apply(this.getOrderLine(shoppinglist, rule.getArticleId()), rule.getAmount());

                    if (minimumAmountRule.hasBeenApplied()) {
                        System.out.println(minimumAmountRule.getReason());
                        success = false;
                    }
                    break;
                case "max":
                    MaximumAmountRule maximumAmountRule = new MaximumAmountRule();

                    maximumAmountRule.apply(this.getOrderLine(shoppinglist, rule.getArticleId()), rule.getAmount());

                    if (maximumAmountRule.hasBeenApplied()) {
                        System.out.println(maximumAmountRule.getReason());
                        success = false;
                    }

                    break;
                default:
                    throw new IllegalArgumentException("Invalid rule type");
            }
        }

        return success;
    }

    private Orderrule getOrderLine(Shoppinglist shoppinglist, int articleId) {
        ArrayList<Orderrule> orderrules = new ArrayList<Orderrule>();

        for (Order order : shoppinglist.getOrders()) {
            for (Orderrule orderrule : order.getOrderrules()) {
                if (orderrule.getArticle().getId() == articleId) {
                    orderrules.add(orderrule);
                }
            }
        }

        int amount = 0;
        for (Orderrule orderrule : orderrules) {
            amount += orderrule.getAmount();
        }

        return new Orderrule(new ArticleRepository().show(articleId), amount);
    }
}
