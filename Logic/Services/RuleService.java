package Logic.Services;

import DataLayer.ArticleRepository;
import Logic.Dtos.src.RuleInformtionDto;
import Logic.Helpers.RuleHelper;
import Logic.Interfaces.Logic.Controllers.BasicRuleInterface;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Rule;
import Logic.Models.Shoppinglist;

import java.util.ArrayList;

public class RuleService {
    public Boolean applyRules(ArrayList<Rule> activeRules, Shoppinglist shoppinglist) {
        Boolean success = true;
        for (Rule rule : activeRules) {
            BasicRuleInterface basicRule = RuleHelper.getCorrectRule(rule.getType());

            RuleInformtionDto ruleInformtion = basicRule.apply(this.getOrderLine(shoppinglist, rule.getArticleId()), rule.getAmount());

            if (!ruleInformtion.isSuccess()) {
                System.out.println(ruleInformtion.getReason());
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

        // TODO: new ArticleRepository(), only works because it is preset.
        return new Orderrule(new ArticleRepository().show(articleId), amount);
    }
}
