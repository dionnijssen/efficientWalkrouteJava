package Logic.Services;

import DataLayer.ArticleRepository;
import Logic.Helpers.RuleHelper;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Rule;
import Logic.Models.Shoppinglist;
import Logic.Rules.BasicRule;

import java.util.ArrayList;

public class CreateWalkRouteService {
    public Boolean applyRules(ArrayList<Rule> activeRules, Shoppinglist shoppinglist) {
        Boolean success = true;
        for (Rule rule : activeRules) {
            BasicRule basicRule = RuleHelper.getCorrectRule(rule.getType());

            basicRule.apply(this.getOrderLine(shoppinglist, rule.getArticleId()), rule.getAmount());

            if (basicRule.hasBeenApplied()) {
                System.out.println(basicRule.getReason());
                success = false;
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
