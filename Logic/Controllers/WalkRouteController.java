package Logic.Controllers;

import DataLayer.WalkRouteRepository;
import Logic.Interfaces.Logic.Controllers.WalkRouteControllerInterface;
import Logic.Models.Article;
import Logic.Models.WalkRoute;

import java.util.ArrayList;

public class WalkRouteController implements WalkRouteControllerInterface {
    WalkRouteRepository walkRouteRepo;

    public WalkRouteController(WalkRouteRepository walkRouteRepository) {
        walkRouteRepo = walkRouteRepository;
    }

    public WalkRoute show(int id) {
        return this.walkRouteRepo.show(id);
    }

    public WalkRoute create(ArrayList<Article> articles) {
        int highestId = 0;
        for (WalkRoute walkRoute : this.walkRouteRepo.get()) {
            if (walkRoute.getId() > highestId) {
                highestId = walkRoute.getId();
            }
        }

        WalkRoute walkroute = new WalkRoute(highestId + 1);

        for (Article article : articles) {
            walkroute.addArticle(article);
        }

        return this.walkRouteRepo.store(walkroute);
    }
}
