package Logic;

import DataLayer.OrderRepository;
import Logic.Controllers.*;

// Het enige wat deze class doet is weten hoe de objecten gemaakt moeten worden. FactoryPattern -> opzoeken en snappen. -> opzoeken hoe het in Laravel zit
// Dit concept heb je bij de meeste OOP opgezette projecten. Bij Laravel word dit oa gedaan met de AppServiceProvider.
// Opzoeken Inversion of control (IOC)
public class ControllerFactory {
    private RepositoryFactory repositoryFactory;
    private ArticleController articleController;
    private DepartmentController departmentController;
    private OrderManager orderManager;
    private OrderController orderController;
    private OrderruleController orderruleController;
    private ShoppinglistController shoppinglistController;
    private UserController userController;
    private WalkRouteController walkRouteController;

    public ControllerFactory(
            RepositoryFactory repositoryFactory
    ) {
        this.repositoryFactory = repositoryFactory;
    }

    public ArticleController getArticleController()
    {
        if (null == this.articleController) {
            this.articleController = new ArticleController(this.repositoryFactory.getArticleRepository());
        }

        return this.articleController;
    }

    public DepartmentController getDepartmentController()
    {
        if (null == this.departmentController) {
            this.departmentController = new DepartmentController(this.repositoryFactory.getDepartmentRepository());
        }

        return this.departmentController;
    }
    public OrderController getOrderController()
    {
        if (null == this.orderController) {
            this.orderController = new OrderController(this.repositoryFactory.getOrderRepository());
        }

        return this.orderController;
    }

    public OrderruleController getOrderruleController()
    {
        if (null == this.orderruleController) {
            this.orderruleController = new OrderruleController(this.repositoryFactory.getOrderruleRepository());
        }

        return this.orderruleController;
    }

    public ShoppinglistController getShoppinglistController()
    {
        if (null == this.shoppinglistController) {
            this.shoppinglistController = new ShoppinglistController(this.repositoryFactory.getShoppinglistRepository());
        }

        return this.shoppinglistController;
    }

    public UserController getUserController()
    {
        if (null == this.userController) {
            this.userController = new UserController(this.repositoryFactory.getUserRepository());
        }

        return this.userController;
    }

    public WalkRouteController getWalkRouteController()
    {
        if (null == this.walkRouteController) {
            this.walkRouteController = new WalkRouteController(this.repositoryFactory.getWalkRouteRepository());
        }

        return this.walkRouteController;
    }

    public OrderManager getOrderManager()
    {
        if (null == this.orderManager) {
            this.orderManager = new OrderManager(
                    this.repositoryFactory.getShoppinglistRepository(),
                    this.repositoryFactory.getArticleRepository()
            );
        }

        return this.orderManager;
    }
}
