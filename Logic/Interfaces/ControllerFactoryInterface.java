package Logic.Interfaces;

import Logic.Controllers.*;

public interface ControllerFactoryInterface {
    ArticleControllerInterface getArticleController();

    DepartmentControllerInterface getDepartmentController();

    OrderControllerInterface getOrderController();

    OrderruleControllerInterface getOrderruleController();

    ShoppinglistControllerInterface getShoppinglistController();

    UserControllerInterface getUserController();

    WalkRouteControllerInterface getWalkRouteController();

    OrderManagerInterface getOrderManager();
}
