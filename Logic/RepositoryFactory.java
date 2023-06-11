package Logic;

import DataLayer.*;

public class RepositoryFactory {
    private ArticleRepository articleRepository;
    private DepartmentRepository departmentRepository;
    private OrderRepository orderRepository;
    private ShoppinglistRepository shoppinglistRepository;
    private WalkRouteRepository walkRouteRepository;

    private RuleRepository ruleRepository;

    public ArticleRepository getArticleRepository() {
        if (null == this.articleRepository) {
            this.articleRepository = new ArticleRepository();
        }

        return this.articleRepository;
    }

    public DepartmentRepository getDepartmentRepository() {
        if (null == this.departmentRepository) {
            this.departmentRepository = new DepartmentRepository();
        }

        return this.departmentRepository;
    }

    public OrderRepository getOrderRepository() {
        if (null == this.orderRepository) {
            this.orderRepository = new OrderRepository();
        }

        return this.orderRepository;
    }

    public ShoppinglistRepository getShoppinglistRepository() {
        if (null == this.shoppinglistRepository) {
            this.shoppinglistRepository = new ShoppinglistRepository();
        }

        return this.shoppinglistRepository;
    }

    public WalkRouteRepository getWalkRouteRepository() {
        if (null == this.walkRouteRepository) {
            this.walkRouteRepository = new WalkRouteRepository();
        }

        return this.walkRouteRepository;
    }

    public RuleRepository getRuleRepository() {
        if (null == this.ruleRepository) {
            this.ruleRepository = new RuleRepository();
        }

        return this.ruleRepository;
    }
}
