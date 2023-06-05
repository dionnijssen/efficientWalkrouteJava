package Logic.Controllers;

import DataLayer.*;
import Logic.Models.*;
import Logic.Services.CreateWalkRouteService;

import java.util.ArrayList;

public class WalkRouteManager {
    WalkRouteRepository walkRouteRepo;
    RuleRepository ruleRepo;
    ArticleRepository articleRepo;
    CreateWalkRouteService createWalkRouteService;

    public WalkRouteManager(
            WalkRouteRepository walkRouteRepository,
            RuleRepository ruleRepository,
            ArticleRepository articleRepository,
            CreateWalkRouteService createWalkRouteService
    ) {
        this.walkRouteRepo = walkRouteRepository;
        this.ruleRepo = ruleRepository;
        this.articleRepo = articleRepository;
        this.createWalkRouteService = createWalkRouteService;
    }

    public Shoppinglist createWalkRoute(Shoppinglist shoppinglist) {
        ArrayList articleIds = this.getShoppinglistArticles(shoppinglist);
        ArrayList<Rule> activeRules = this.getRulesForShoppinglistArticles(articleIds);

        ArrayList failedRules = this.createWalkRouteService.applyRules(activeRules, shoppinglist);

        if (failedRules.size() > 0) {
//            return failedRules;

            // Notify user of failed rules
            // new Interface controller which shows this?
        }

        return this.calculateWalkroute(shoppinglist);
    }

    private Shoppinglist calculateWalkroute(Shoppinglist shoppinglist) {
        ArrayList articles = this.getShoppinglistArticles(shoppinglist);
        ArticleRepository articleRepo = new ArticleRepository();
        // Sort Articles by department order
        articles.sort((article1, article2) -> {
            Department department1 = this.getDepartmentForArticle((int) article1);
            Department department2 = this.getDepartmentForArticle((int) article2);

            return department1.getOrder() - department2.getOrder();
        });

        ArrayList<Article> walkrouteOrderedArticles = new ArrayList<Article>();

        // Add articles to walkroute
        for (Object article : articles) {
            Article addArticle = articleRepo.show((Integer) article);
            walkrouteOrderedArticles.add(addArticle);
        }

        WalkRoute walkRoute = new WalkRouteController(this.walkRouteRepo).create(walkrouteOrderedArticles);

        shoppinglist.setWalkRouteId(walkRoute.getId());
        new ShoppinglistController(new ShoppinglistRepository()).update(shoppinglist);

        return shoppinglist;
    }

    private Department getDepartmentForArticle(int articleId) {
        ArrayList<Department> departments = this.getDepartments();

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

        for (Order order : shoppinglist.getOrders()) {
            for (Orderrule orderrule : order.getOrderrules()) {
                if (orderrule.getArticle().getId() == article.getId()) {
                    return orderrule.getAmount();
                }
            }
        }

        throw new IllegalArgumentException("Article not found in shoppinglist");
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
        return new DepartmentRepository().get();
    }
}
