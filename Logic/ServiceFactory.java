package Logic;

import Logic.Controllers.*;
import Logic.Interfaces.Logic.Controllers.*;
import Logic.Services.CreateWalkRouteService;

public class ServiceFactory {
    private RepositoryFactory repositoryFactory;
    private WalkRouteControllerInterface walkRouteController;

    private CreateWalkRouteService walkRouteService;


    private WalkRouteManager walkrouteManager;

    public ServiceFactory(
            RepositoryFactory repositoryFactory
    ) {
        this.repositoryFactory = repositoryFactory;
    }

    public CreateWalkRouteService getCreateWalkRouteService() {
        if (null == this.walkRouteService) {
            this.walkRouteService = new CreateWalkRouteService(this.repositoryFactory.getArticleRepository());
        }

        return this.walkRouteService;
    }
}
