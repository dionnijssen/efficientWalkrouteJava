package Logic.Interfaces.Logic;

import Logic.Interfaces.Logic.Controllers.*;

public interface ControllerFactoryInterface {
    ArticleControllerInterface getArticleController();

    DepartmentControllerInterface getDepartmentController();

    OrderControllerInterface getOrderController();

    OrderruleControllerInterface getOrderruleController();

    ShoppinglistControllerInterface getShoppinglistController();

    WalkRouteControllerInterface getWalkRouteController();

    OrderManagerInterface getOrderManager();
}
