package Logic.Interfaces.Logic;

import Logic.Interfaces.Logic.Controllers.*;

public interface ControllerFactoryInterface {
    ArticleControllerInterface getArticleController();

    OrderControllerInterface getOrderController();

    ShoppinglistControllerInterface getShoppinglistController();

    WalkRouteControllerInterface getWalkRouteController();

    OrderManagerInterface getOrderManager();
}
