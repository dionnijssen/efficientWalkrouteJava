package Logic;

import Logic.Services.CreateWalkRouteService;

public class ServiceFactory {
    private CreateWalkRouteService walkRouteService;

    public CreateWalkRouteService getCreateWalkRouteService() {
        if (null == this.walkRouteService) {
            this.walkRouteService = new CreateWalkRouteService();
        }

        return this.walkRouteService;
    }
}
