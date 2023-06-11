package DataLayer;

import Logic.Models.WalkRoute;

import java.util.ArrayList;

public class WalkRouteRepository {
    private ArrayList<WalkRoute> walkRoutes;

    public WalkRouteRepository() {
        this.walkRoutes = new ArrayList<WalkRoute>();
    }

    public ArrayList<WalkRoute> get() {
        return this.walkRoutes;
    }

    public WalkRoute show(int walkRouteId) {
        for (WalkRoute walkRoute : this.get()) {
            if (walkRoute.getId() == walkRouteId) {
                return walkRoute;
            }
        }

        return null;
    }

    public WalkRoute store(WalkRoute walkRoute) {
        this.walkRoutes.add(walkRoute);
        return walkRoute;
    }
}
