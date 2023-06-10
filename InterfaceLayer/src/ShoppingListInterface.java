package src;

import Logic.ControllerFactory;
import Logic.Helpers.Helpers;
import Logic.Models.Shoppinglist;
import Logic.UiFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ShoppingListInterface {
    private ControllerFactory controllerFactory;
    private UiFactory uiFactory;

    public ShoppingListInterface(
            ControllerFactory controllerFactory,
            UiFactory uiFactory
    ) {
        this.controllerFactory = controllerFactory;
        this.uiFactory = uiFactory;
    }

    public void createShoppingList() throws IOException, ParseException {
        Boolean success = this.controllerFactory.getShoppinglistController().create();

        if (success) {
            System.out.println("Shoppinglist created");
        } else {
            System.out.println("Something went wrong, please try again");

            throw new RuntimeException("Something went wrong, please try again");
        }
        this.uiFactory.getHomeInterface().home();
    }

    public void selectShoppinglist() throws IOException, ParseException {
        System.out.println("");
        System.out.println("Select a shoppinglist:");

        Shoppinglist selectedShoppinglist = null;

        try {
            ArrayList shoppinglistOptions = new ArrayList<>();
            ArrayList<Shoppinglist> shoppinglists = this.controllerFactory.getShoppinglistController().get();

            if (shoppinglists.size() == 0) {
                throw new RuntimeException("No shoppinglists found");
            }

            int count = 1;
            for (Shoppinglist shoppinglist : shoppinglists) {
                System.out.println(count + " " + shoppinglist.getDate());
                shoppinglistOptions.add(Integer.toString(shoppinglist.getId()));
                count++;
            }

            String selected = Helpers.readOption(shoppinglistOptions);

            selectedShoppinglist = this.controllerFactory.getShoppinglistController().show(Integer.parseInt(selected));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            this.uiFactory.getHomeInterface().home();
        }


        shoppingListOptions(selectedShoppinglist);
    }

    public void shoppingListOptions(Shoppinglist shoppinglist) throws IOException, ParseException {
        System.out.println("");
        System.out.println("Shoppinglist actions:");
        System.out.println("1. Create order");
        System.out.println("2. Order actions");
        System.out.println("3. Create Walkroute");
        System.out.println("4. Show Walkroute");

        ArrayList<String> options = new ArrayList<String>();
        options.add("1");
        options.add("2");
        options.add("3");
        options.add("4");

        String option = Helpers.readOption(options);

        switch (Integer.parseInt(option)) {
            case 1 -> this.uiFactory.getOrderInterface().createOrder(shoppinglist);
            case 2 -> this.uiFactory.getOrderInterface().selectOrder(shoppinglist);
            case 3 -> this.uiFactory.getWalkrouteInterface().createWalkroute(shoppinglist);
            case 4 -> this.uiFactory.getWalkrouteInterface().showWalkRoute(shoppinglist);
        }
    }
}
