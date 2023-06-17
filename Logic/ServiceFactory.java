package Logic;

import Logic.Helpers.RuleHelper;
import Logic.Services.RuleService;

public class ServiceFactory {
    private RuleService walkRouteService;

    public RuleService getCreateWalkRouteService() {
        if (null == this.walkRouteService) {
            this.walkRouteService = new RuleService(new RuleHelper());
        }

        return this.walkRouteService;
    }
}
