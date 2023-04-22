package Logic.Interfaces;

import Logic.Models.Shoppinglist;

import java.io.IOException;
import java.util.ArrayList;

public interface ShoppinglistControllerInterface {
    void create();

    Shoppinglist selectShoppingList() throws IOException;

    Shoppinglist show(int id);

    ArrayList<Shoppinglist> get();

    Boolean store(Shoppinglist shoppinglist);
}
