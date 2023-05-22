package Logic.Controllers;

import DataLayer.ArticleRepository;
import DataLayer.RuleRepository;
import DataLayer.WalkRouteRepository;
import Logic.Models.Rule;
import Logic.Models.Shoppinglist;
import Logic.Rules.BasicRule;
import Logic.Rules.MinimumAmountRule;

import java.util.ArrayList;

public class WalkRouteManager {
    WalkRouteRepository walkRouteRepo;
    RuleRepository ruleRepo;
    ArticleRepository articleRepo;

    public WalkRouteManager(
            WalkRouteRepository walkRouteRepository,
            RuleRepository ruleRepository,
            ArticleRepository articleRepository
    ) {
        this.walkRouteRepo = walkRouteRepository;
        this.ruleRepo = ruleRepository;
        this.articleRepo = articleRepository;
    }

    public ArrayList createWalkRoute(Shoppinglist shoppinglist) {
        ArrayList articleIds = this.getShoppinglistArticles(shoppinglist);
        ArrayList<Rule> activeRules = this.getRulesForShoppinglistArticles(articleIds);

        ArrayList appliedRules = new ArrayList();
        for (Rule rule : activeRules) {
            switch (rule.getType()) {
                case "min":
                    MinimumAmountRule minimumAmountRule = new MinimumAmountRule(shoppinglist, this.articleRepo.show(rule.getArticleId()), rule.getAmount());
                    minimumAmountRule.apply();

                    if (minimumAmountRule.hasBeenApplied()) {
                        appliedRules.add(minimumAmountRule);
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

    private ArrayList getShoppinglistArticles(Shoppinglist shoppinglist) {
        ArrayList articleIds = new ArrayList();

        shoppinglist.getOrders().forEach(order -> {
            order.getOrderrules().forEach(orderrule -> {
                articleIds.add(orderrule.getArticle().getId());
            });
        });

        return articleIds;
    }

    private ArrayList getRulesForShoppinglistArticles(ArrayList articleIds) {
        ArrayList rulesForShoppinglist = new ArrayList();

        this.ruleRepo.get().forEach(rule -> {
            if (articleIds.contains(rule.getArticleId())) {
                rulesForShoppinglist.add(rule);
            }
        });

        return rulesForShoppinglist;
    }

    private ArrayList getDepartments() {
        return new ArrayList();
    }
}
