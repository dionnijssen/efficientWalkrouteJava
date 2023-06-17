package Logic.Controllers;

import DataLayer.ShoppinglistRepository;
import Logic.Interfaces.Logic.Controllers.ShoppinglistControllerInterface;
import Logic.Models.Order;
import Logic.Models.Shoppinglist;
import Logic.Models.WalkRoute;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShoppinglistController implements ShoppinglistControllerInterface {

    ShoppinglistRepository shoppinglistRepo;

    public ShoppinglistController(ShoppinglistRepository shoppinglistRepository) {
        shoppinglistRepo = shoppinglistRepository;
    }

    public Boolean create() {
        System.out.println();

        LocalDate today = LocalDate.now();

        Shoppinglist newShoppinglist = this.createShoppingList(today, new ArrayList<Order>(), null);
        return this.store(newShoppinglist);
    }

    public Shoppinglist show(int id) {
        return this.shoppinglistRepo.show(id);
    }

    public ArrayList<Shoppinglist> get() {
        return this.shoppinglistRepo.get();
    }

    private Boolean store(Shoppinglist shoppinglist) {
        if (this.shoppinglistRepo.store(shoppinglist) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean update(Shoppinglist shoppinglist) {
        if (this.shoppinglistRepo.update(shoppinglist) != null) {
            return true;
        } else {
            return false;
        }
    }

    private Shoppinglist createShoppingList(LocalDate date, ArrayList<Order> orders, WalkRoute walkRoute) {
        ArrayList<Shoppinglist> shoppinglists = shoppinglistRepo.get();

        LocalDate today = LocalDate.now();

        int id = (shoppinglists.size() + 1);

        return new Shoppinglist(id, today);
    }
}
