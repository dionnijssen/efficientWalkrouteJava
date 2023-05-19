package Logic.Interfaces;

import DataLayer.*;

public interface RepositoryFactoryInterface {
    ArticleRepository getArticleRepository();

    DepartmentRepository getDepartmentRepository();

    OrderRepository getOrderRepository();

    OrderruleRepository getOrderruleRepository();

    ShoppinglistRepository getShoppinglistRepository();

    WalkRouteRepository getWalkRouteRepository();
}
