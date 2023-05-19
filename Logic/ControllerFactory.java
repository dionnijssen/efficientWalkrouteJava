package Logic;

import Logic.Controllers.*;
import Logic.Interfaces.Logic.*;
import Logic.Interfaces.Logic.Controllers.*;

// Het enige wat deze class doet is weten hoe de objecten gemaakt moeten worden. FactoryPattern -> opzoeken en snappen. -> opzoeken hoe het in Laravel zit
// Dit concept heb je bij de meeste OOP opgezette projecten. Bij Laravel word dit oa gedaan met de AppServiceProvider.
// Opzoeken Inversion of control (IOC)
public class ControllerFactory implements ControllerFactoryInterface {
    private RepositoryFactory repositoryFactory;
    private ArticleControllerInterface articleController;
    private DepartmentControllerInterface departmentController;
    private OrderManagerInterface orderManager;
    private OrderControllerInterface orderController;
    private OrderruleControllerInterface orderruleController;
    private ShoppinglistControllerInterface shoppinglistController;
    private WalkRouteControllerInterface walkRouteController;

    public ControllerFactory(
            RepositoryFactory repositoryFactory
    ) {
        this.repositoryFactory = repositoryFactory;
    }

    public ArticleControllerInterface getArticleController() {
        if (null == this.articleController) {
            this.articleController = new ArticleController(this.repositoryFactory.getArticleRepository());
        }

        return this.articleController;
    }

    public DepartmentControllerInterface getDepartmentController() {
        if (null == this.departmentController) {
            this.departmentController = new DepartmentController(this.repositoryFactory.getDepartmentRepository());
        }

        return this.departmentController;
    }

    public OrderControllerInterface getOrderController() {
        if (null == this.orderController) {
            this.orderController = new OrderController(this.repositoryFactory.getOrderRepository());
        }

        return this.orderController;
    }

    public OrderruleControllerInterface getOrderruleController() {
        if (null == this.orderruleController) {
            this.orderruleController = new OrderruleController(this.repositoryFactory.getOrderruleRepository());
        }

        return this.orderruleController;
    }

    public ShoppinglistControllerInterface getShoppinglistController() {
        if (null == this.shoppinglistController) {
            this.shoppinglistController = new ShoppinglistController(this.repositoryFactory.getShoppinglistRepository());
        }

        return this.shoppinglistController;
    }

    public WalkRouteControllerInterface getWalkRouteController() {
        if (null == this.walkRouteController) {
            this.walkRouteController = new WalkRouteController(this.repositoryFactory.getWalkRouteRepository());
        }

        return this.walkRouteController;
    }

    public OrderManagerInterface getOrderManager() {
        if (null == this.orderManager) {
            this.orderManager = new OrderManager(
                    this.repositoryFactory.getShoppinglistRepository(),
                    this.repositoryFactory.getArticleRepository()
            );
        }

        return this.orderManager;
    }
}
