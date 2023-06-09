package Logic.Controllers;

import DataLayer.*;
import Logic.Models.*;
import Logic.Services.RuleService;

import java.util.ArrayList;

public class WalkRouteManager {
    WalkRouteRepository walkRouteRepo;
    RuleRepository ruleRepo;
    ArticleRepository articleRepo;
    RuleService ruleService;
    DepartmentRepository departmentRepo;
    WalkRouteController walkrouteController;
    ShoppinglistController shoppinglistController;

    public WalkRouteManager(
            WalkRouteRepository walkRouteRepository,
            RuleRepository ruleRepository,
            ArticleRepository articleRepository,
            RuleService ruleService,
            DepartmentRepository departmentRepository,
            WalkRouteController walkrouteController,
            ShoppinglistController shoppinglistController
    ) {
        this.walkRouteRepo = walkRouteRepository;
        this.ruleRepo = ruleRepository;
        this.articleRepo = articleRepository;
        this.ruleService = ruleService;
        this.departmentRepo = departmentRepository;
        this.walkrouteController = walkrouteController;
        this.shoppinglistController = shoppinglistController;
    }

    public Shoppinglist createWalkRoute(Shoppinglist shoppinglist) {
        ArrayList articleIds = this.getShoppinglistArticles(shoppinglist);
        ArrayList<Rule> activeRules = this.getRulesForShoppinglistArticles(articleIds);

        Boolean success = this.ruleService.applyRules(activeRules, shoppinglist);

        if (success) {
            return this.calculateWalkroute(shoppinglist);
        }

        return shoppinglist;
    }

    private Shoppinglist calculateWalkroute(Shoppinglist shoppinglist) {
        ArrayList articles = this.getShoppinglistArticles(shoppinglist);

        articles.sort((article1, article2) -> {
            Department department1 = this.getDepartmentForArticle((int) article1);
            Department department2 = this.getDepartmentForArticle((int) article2);

            return department1.getOrder() - department2.getOrder();
        });

        ArrayList<Article> walkrouteOrderedArticles = new ArrayList<Article>();

        for (Object article : articles) {
            Article addArticle = this.articleRepo.show((Integer) article);
            walkrouteOrderedArticles.add(addArticle);
        }

        WalkRoute walkRoute = this.walkrouteController.create(walkrouteOrderedArticles);

        shoppinglist.setWalkRouteId(walkRoute.getId());
        this.shoppinglistController.update(shoppinglist);

        return shoppinglist;
    }

    private Department getDepartmentForArticle(int articleId) {
        ArrayList<Department> departments = this.departmentRepo.get();

        for (Department department : departments) {
            if (department.getArticleIds().contains(articleId)) {
                return department;
            }
        }

        return null;
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

    public int getShoppingListArticleAmount(Shoppinglist shoppinglist, Article article) {
        int amount = 0;
        ArrayList amounts = new ArrayList();

        for (Order order : shoppinglist.getOrders()) {
            for (Orderrule orderrule : order.getOrderrules()) {
                if (orderrule.getArticle().getId() == article.getId()) {
                    amounts.add(orderrule.getAmount());
                }
            }
        }

        for (Object amountObject : amounts) {
            amount += (int) amountObject;
        }

        return amount;
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
}
