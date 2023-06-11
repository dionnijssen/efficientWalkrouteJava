package Logic.Interfaces.Logic;

import DataLayer.*;

public interface RepositoryFactoryInterface {
    ArticleRepository getArticleRepository();

    DepartmentRepository getDepartmentRepository();

    OrderRepository getOrderRepository();

    ShoppinglistRepository getShoppinglistRepository();

    WalkRouteRepository getWalkRouteRepository();
}
