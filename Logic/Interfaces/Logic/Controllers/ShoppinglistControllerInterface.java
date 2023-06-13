package Logic.Interfaces.Logic.Controllers;

import Logic.Models.Shoppinglist;

import java.util.ArrayList;

public interface ShoppinglistControllerInterface {
    Boolean create();

    Shoppinglist show(int id);

    ArrayList<Shoppinglist> get();

    Boolean update(Shoppinglist $shoppingListId);
}
