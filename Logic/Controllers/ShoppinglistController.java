package Logic.Controllers;

import DataLayer.ShoppinglistRepository;
import Logic.Helpers.Helpers;
import Logic.Interfaces.ShoppinglistControllerInterface;
import Logic.Models.Order;
import Logic.Models.Shoppinglist;
import Logic.Models.WalkRoute;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShoppinglistController implements ShoppinglistControllerInterface {

    ShoppinglistRepository shoppinglistRepo;

    public ShoppinglistController(ShoppinglistRepository shoppinglistRepository) {
        shoppinglistRepo = shoppinglistRepository;
    }

    public void create() {
        System.out.println();

        LocalDate today = LocalDate.now();

        Shoppinglist newShoppinglist = this.createShoppingList(today, new ArrayList<Order>(), null);
        if (this.store(newShoppinglist)) {
            System.out.println("Shoppinglist created");
        } else {
            System.out.println("Something went wrong, please try again");

            throw new RuntimeException("Something went wrong, please try again");
        }
    }

    public Shoppinglist selectShoppingList() throws IOException {
        ArrayList shoppinglistOptions = new ArrayList<>();
        ArrayList<Shoppinglist> shoppinglists = this.get();

        if (shoppinglists.size() == 0) {
            throw new RuntimeException("No shoppinglists found");
        }

        int count = 1;
        for (Shoppinglist shoppinglist : shoppinglists) {
            System.out.println(count + " " + shoppinglist.date);
            shoppinglistOptions.add(Integer.toString(shoppinglist.id));
            count++;
        }

        String selected = Helpers.readOption(shoppinglistOptions);

        Shoppinglist selectedShoppinglist = this.show(Integer.parseInt(selected));

        return selectedShoppinglist;
    }

    public Shoppinglist show(int id) {
        return this.shoppinglistRepo.show(id);
    }

    public ArrayList<Shoppinglist> get() {
        return this.shoppinglistRepo.get();
    }

    public Boolean store(Shoppinglist shoppinglist) {
        return this.shoppinglistRepo.store(shoppinglist);
    }

    private Shoppinglist createShoppingList(LocalDate date, ArrayList<Order> orders, WalkRoute walkRoute) {
        ArrayList<Shoppinglist> shoppinglists = shoppinglistRepo.get();

        LocalDate today = LocalDate.now();

        for (int i = 0; i < shoppinglists.size(); i++) {
            if ((shoppinglists.get(i)).date == today) {
                return null;
            }
        }
        int id = (shoppinglists.size() + 1);

        return new Shoppinglist(id, today, null, null);
    }
}
