package Logic;

import Logic.Services.RuleService;

public class ServiceFactory {
    private RuleService walkRouteService;

    public RuleService getCreateWalkRouteService() {
        if (null == this.walkRouteService) {
            this.walkRouteService = new RuleService();
        }

        return this.walkRouteService;
    }
}
