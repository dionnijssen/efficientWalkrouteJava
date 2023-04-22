package DataLayer;

import DataLayer.Interfaces.RepositoryInterface;
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
        ArrayList<WalkRoute> walkRoutes = this.get();

        for (int i = 0; i < walkRoutes.size(); i++) {
            if (walkRoutes.get(i).id == walkRouteId) {
                return walkRoutes.get(i);
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
            if (walkRoutes.get(i).id == walkRoute.id) {
                walkRoutes.set(i, walkRoute);

                return walkRoute;
            }
        }

        return null;
    }

    public boolean delete(WalkRoute walkRoute) {
        for (int i = 0; i < this.walkRoutes.size(); i++) {
            if (walkRoutes.get(i).id == walkRoute.id) {
                walkRoutes.remove(i);

                return true;
            }
        }

        return false;
    }
}
