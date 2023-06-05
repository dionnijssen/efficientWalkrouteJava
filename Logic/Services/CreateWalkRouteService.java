package Logic.Services;

import DataLayer.ArticleRepository;
import Logic.Models.Rule;
import Logic.Models.Shoppinglist;
import Logic.Rules.MinimumAmountRule;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateWalkRouteService {
    private ArticleRepository articleRepo;

    public CreateWalkRouteService(ArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    public ArrayList applyRules(ArrayList<Rule> activeRules, Shoppinglist shoppinglist) {
        ArrayList appliedRules = new ArrayList();
        for (Rule rule : activeRules) {
            switch (rule.getType()) {
                case "min":
                    MinimumAmountRule minimumAmountRule = new MinimumAmountRule(shoppinglist, this.articleRepo.show(rule.getArticleId()), rule.getAmount());



                    minimumAmountRule.setAmount(this.getOrderLineAmount(shoppinglist, rule.getArticleId()));
                    minimumAmountRule.apply();

                    if (minimumAmountRule.hasBeenApplied()) {
                        appliedRules.add(minimumAmountRule.getReason());
                    }
                    break;
                case "max":
                    break;
                default:
                    throw new IllegalArgumentException("Invalid rule type");
            }
        }

        return appliedRules;
    }

    private int getOrderLineAmount(Shoppinglist shoppinglist, int articleId) {
        AtomicInteger amount = new AtomicInteger();

        shoppinglist.getOrders().forEach(order -> {
            order.getOrderrules().forEach(orderrule -> {
                if (orderrule.getArticle().getId() == articleId) {
                    amount.set(orderrule.getAmount());
                }
            });
        });

        return amount.get();
    }
}
