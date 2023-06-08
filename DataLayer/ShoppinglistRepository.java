package DataLayer;

import Logic.Interfaces.Data.RepositoryInterface;
import Logic.Models.Order;
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
            if (shoppinglist.getId() == id) {
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
            if (shoppinglists.get(i).getId() == shoppinglist.getId()) {
                shoppinglists.set(i, shoppinglist);

                return shoppinglist;
            }
        }

        return null;
    }

    public boolean delete(Shoppinglist shoppinglist) {
        return this.shoppinglists.remove(shoppinglist);
    }

    public Order updateOrder(Order order) {
        for (Shoppinglist shoppinglist : this.shoppinglists) {
            for (Order order1 : shoppinglist.getOrders()) {
                if (order1.getId() == order.getId()) {
                    this.shoppinglists.get(
                            this.shoppinglists.indexOf(shoppinglist))
                            .getOrders().set(shoppinglist.getOrders().indexOf(order1), order);
                    return order1;
                }
            }
        }

        return null;
    }
}
