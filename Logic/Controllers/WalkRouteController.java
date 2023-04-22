package Logic.Controllers;

import DataLayer.WalkRouteRepository;
import Logic.Interfaces.WalkRouteControllerInterface;
import Logic.Models.WalkRoute;

public class WalkRouteController implements WalkRouteControllerInterface {
    WalkRouteRepository walkRouteRepo;

    public WalkRouteController(WalkRouteRepository walkRouteRepository) {
        walkRouteRepo = walkRouteRepository;
    }

    public WalkRoute show(int id) {
        return this.walkRouteRepo.show(id);
    }

//    public WalkRoute create(WalkRoute walkroute) {
//        return this.walkRouteRepo.create(walkroute);
//    }

//    public WalkRoute update(WalkRoute walkroute) {
//        return this.walkRouteRepo.update(walkroute);
//    }

//    public boolean delete (WalkRoute walkroute) {
//        return this.walkRouteRepo.delete(walkroute);
//    }
}
