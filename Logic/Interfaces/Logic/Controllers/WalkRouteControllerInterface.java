package Logic.Interfaces.Logic.Controllers;

import Logic.Models.Article;
import Logic.Models.WalkRoute;

import java.util.ArrayList;

public interface WalkRouteControllerInterface {
    WalkRoute show(int id);
    WalkRoute create(ArrayList<Article> articles);
}
