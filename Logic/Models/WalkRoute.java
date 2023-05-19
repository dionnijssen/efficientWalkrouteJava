package Logic.Models;

public class WalkRoute {
    private int id;
    private String walk_route;

    public WalkRoute(int id, String walk_route) {
        this.id = id;
        this.walk_route = walk_route;
    }

    public int getId() {
        return this.id;
    }
}
