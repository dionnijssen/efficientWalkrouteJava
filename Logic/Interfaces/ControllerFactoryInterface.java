package Logic.Interfaces;

import Logic.Controllers.*;

public interface ControllerFactoryInterface {
    ArticleControllerInterface getArticleController();

    DepartmentControllerInterface getDepartmentController();

    OrderControllerInterface getOrderController();

    OrderruleControllerInterface getOrderruleController();

    ShoppinglistControllerInterface getShoppinglistController();

    WalkRouteControllerInterface getWalkRouteController();

    OrderManagerInterface getOrderManager();
}
