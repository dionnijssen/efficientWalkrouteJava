package Logic;

import DataLayer.*;
import Logic.Interfaces.Logic.RepositoryFactoryInterface;

public class RepositoryFactory implements RepositoryFactoryInterface {
    private ArticleRepository articleRepository;
    private DepartmentRepository departmentRepository;
    private OrderRepository orderRepository;
    private OrderruleRepository orderruleRepository;
    private ShoppinglistRepository shoppinglistRepository;
    private WalkRouteRepository walkRouteRepository;

    private RuleRepository ruleRepository;

    public ArticleRepository getArticleRepository()
    {
        if (null == this.articleRepository) {
            this.articleRepository = new ArticleRepository();
        }

        return this.articleRepository;
    }

    public DepartmentRepository getDepartmentRepository()
    {
        if (null == this.departmentRepository) {
            this.departmentRepository = new DepartmentRepository();
        }

        return this.departmentRepository;
    }

    public OrderRepository getOrderRepository()
    {
        if (null == this.orderRepository) {
            this.orderRepository = new OrderRepository();
        }

        return this.orderRepository;
    }

    public OrderruleRepository getOrderruleRepository()
    {
        if (null == this.orderruleRepository) {
            this.orderruleRepository = new OrderruleRepository();
        }

        return this.orderruleRepository;
    }

    public ShoppinglistRepository getShoppinglistRepository()
    {
        if (null == this.shoppinglistRepository) {
            this.shoppinglistRepository = new ShoppinglistRepository();
        }

        return this.shoppinglistRepository;
    }

    public WalkRouteRepository getWalkRouteRepository()
    {
        if (null == this.walkRouteRepository) {
            this.walkRouteRepository = new WalkRouteRepository();
        }

        return this.walkRouteRepository;
    }

    public RuleRepository getRuleRepository()
    {
        if (null == this.ruleRepository) {
            this.ruleRepository = new RuleRepository();
        }

        return this.ruleRepository;
    }
}
