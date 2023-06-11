package Logic;

import src.HomeInterface;
import src.OrderInterface;
import src.ShoppingListInterface;
import src.WalkrouteInterface;

public class UiFactory {
    private ControllerFactory controllerFactory;
    private RepositoryFactory repositoryFactory;

    private HomeInterface homeInterface;
    private OrderInterface orderInterface;
    private ShoppingListInterface shoppingListInterface;
    private WalkrouteInterface walkrouteInterface;

    public UiFactory(
            ControllerFactory controllerFactory,
            RepositoryFactory repositoryFactory
    ) {
        this.controllerFactory = controllerFactory;
        this.repositoryFactory = repositoryFactory;
    }

    public HomeInterface getHomeInterface() {
        if (null == this.homeInterface) {
            this.homeInterface = new HomeInterface(
                    this
            );
        }

        return this.homeInterface;
    }

    public OrderInterface getOrderInterface() {
        if (null == this.orderInterface) {
            this.orderInterface = new OrderInterface(
                    this.controllerFactory,
                    this
            );
        }

        return this.orderInterface;
    }

    public ShoppingListInterface getShoppingListInterface() {
        if (null == this.shoppingListInterface) {
            this.shoppingListInterface = new ShoppingListInterface(
                    this.controllerFactory,
                    this
            );
        }

        return this.shoppingListInterface;
    }

    public WalkrouteInterface getWalkrouteInterface() {
        if (null == this.walkrouteInterface) {
            this.walkrouteInterface = new WalkrouteInterface(
                    this.controllerFactory,
                    this.repositoryFactory,
                    this
            );
        }

        return this.walkrouteInterface;
    }
}
