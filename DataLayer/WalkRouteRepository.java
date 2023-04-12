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
        ArrayList<WalkRoute> walkRoutes = this.get();

        for (int i = 0; i < walkRoutes.size(); i++) {
            if (walkRoutes.get(i).id == walkRouteId) {
                return walkRoutes.get(i);
            }
        }

        return null;
    }

    public boolean create(WalkRoute walkRoute) {
        return this.walkRoutes.add(walkRoute);
    }

    public boolean update(WalkRoute walkRoute) {
        for (int i = 0; i < this.walkRoutes.size(); i++) {
            if (walkRoutes.get(i).id == walkRoute.id) {
                walkRoutes.set(i, walkRoute);

                return true;
            }
        }

        return false;
    }

    public boolean delete(int walkRouteId) {
        for (int i = 0; i < this.walkRoutes.size(); i++) {
            if (walkRoutes.get(i).id == walkRouteId) {
                walkRoutes.remove(i);

                return true;
            }
        }

        return false;
    }
}
