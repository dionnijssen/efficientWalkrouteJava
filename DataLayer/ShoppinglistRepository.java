package DataLayer;

import DataLayer.Interfaces.RepositoryInterface;
import Logic.Models.Shoppinglist;

import java.util.ArrayList;

public class ShoppinglistRepository implements RepositoryInterface<Shoppinglist> {

    private ArrayList<Shoppinglist> shoppinglists;

    public ShoppinglistRepository() {
        this.shoppinglists = new ArrayList<Shoppinglist>();
    }

    public ArrayList<Shoppinglist> get() {
        return this.shoppinglists;
    }

    public Shoppinglist show(int id) {
        for (Shoppinglist shoppinglist : (get())) {
            if (shoppinglist.id == id) {
                return shoppinglist;
            }
        }

        return null;
    }

    public Shoppinglist store(Shoppinglist shoppinglist) {
        this.shoppinglists.add(shoppinglist);

        return shoppinglist;
    }

    public Shoppinglist update(Shoppinglist shoppinglist) {
        for (int i = 0; i < this.shoppinglists.size(); i++) {
            if (shoppinglists.get(i).id == shoppinglist.id) {
                shoppinglists.set(i, shoppinglist);

                return shoppinglist;
            }
        }

        return null;
    }

    public boolean delete(Shoppinglist shoppinglist) {
        return this.shoppinglists.remove(shoppinglist);
    }
}
