package DataLayer;

import Logic.Interfaces.Data.RepositoryInterface;
import Logic.Models.WalkRoute;

import java.util.ArrayList;

public class WalkRouteRepository implements RepositoryInterface<WalkRoute> {
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

    public WalkRoute update(WalkRoute walkRoute) {
        for (int i = 0; i < this.walkRoutes.size(); i++) {
            if (walkRoutes.get(i).getId() == walkRoute.getId()) {
                walkRoutes.set(i, walkRoute);

                return walkRoute;
            }
        }

        return null;
    }

    public boolean delete(WalkRoute walkRoute) {
        for (int i = 0; i < this.walkRoutes.size(); i++) {
            if (walkRoutes.get(i).getId() == walkRoute.getId()) {
                walkRoutes.remove(i);

                return true;
            }
        }

        return false;
    }
}
