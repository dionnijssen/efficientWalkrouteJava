package Logic.Interfaces;

import Logic.Controllers.*;

public interface ControllerFactoryInterface {
    ArticleController getArticleController();

    DepartmentController getDepartmentController();

    OrderController getOrderController();

    OrderruleController getOrderruleController();

    ShoppinglistController getShoppinglistController();

    UserController getUserController();

    WalkRouteController getWalkRouteController();

    OrderManager getOrderManager();
}
