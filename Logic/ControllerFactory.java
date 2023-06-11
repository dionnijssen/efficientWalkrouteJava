package Logic;

import Logic.Controllers.*;
import Logic.Interfaces.Logic.Controllers.*;

public class ControllerFactory {
    private RepositoryFactory repositoryFactory;
    private ArticleControllerInterface articleController;
    private OrderManagerInterface orderManager;
    private OrderControllerInterface orderController;
    private ShoppinglistControllerInterface shoppinglistController;
    private WalkRouteControllerInterface walkRouteController;


    private WalkRouteManager walkrouteManager;
    private ServiceFactory serviceFactory;

    public ControllerFactory(
            RepositoryFactory repositoryFactory,
            ServiceFactory serviceFactory
    ) {
        this.repositoryFactory = repositoryFactory;
        this.serviceFactory = serviceFactory;
    }

    public ArticleControllerInterface getArticleController() {
        if (null == this.articleController) {
            this.articleController = new ArticleController(this.repositoryFactory.getArticleRepository());
        }

        return this.articleController;
    }

    public OrderControllerInterface getOrderController() {
        if (null == this.orderController) {
            this.orderController = new OrderController(this.repositoryFactory.getOrderRepository());
        }

        return this.orderController;
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
                    this.repositoryFactory.getShoppinglistRepository()
            );
        }

        return this.orderManager;
    }

    public WalkRouteManager getWalkrouteManager() {
        if (null == this.walkrouteManager) {
            this.walkrouteManager = new WalkRouteManager(
                    this.repositoryFactory.getWalkRouteRepository(),
                    this.repositoryFactory.getRuleRepository(),
                    this.repositoryFactory.getArticleRepository(),
                    this.serviceFactory.getCreateWalkRouteService(),
                    this.repositoryFactory.getDepartmentRepository(),
                    (WalkRouteController) this.getWalkRouteController(),
                    (ShoppinglistController) this.getShoppinglistController()
            );
        }

        return this.walkrouteManager;
    }
}
