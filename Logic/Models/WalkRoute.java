package Logic.Models;

import java.util.ArrayList;

public class WalkRoute {
    private int id;
    private ArrayList<Article> walk_route;

    public WalkRoute(int id) {
        this.id = id;
        this.walk_route = new ArrayList();
    }

    public int getId() {
        return this.id;
    }

    public ArrayList getWalkRoute() {
        return this.walk_route;
    }

    public void addArticle(Article article) {
        this.walk_route.add(article);
    }

    public ArrayList<Article> getWalkroute() {
        return this.walk_route;
    }
}
