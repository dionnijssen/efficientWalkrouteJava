package src;

import Logic.Helpers.Helpers;
import Logic.UiFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class HomeInterface {
    private UiFactory uiFactory;

    public HomeInterface(
            UiFactory uiFactory
    ) {
        this.uiFactory = uiFactory;
    }

    public void home() throws IOException, ParseException {
        System.out.println("");
        System.out.println("Select action:");
        System.out.println("1. Create shoppinglist for today");
        System.out.println("2. Shoppinglist options");

        ArrayList<String> options = new ArrayList<String>();
        options.add("1");
        options.add("2");

        String option = Helpers.readOption(options);

        switch (Integer.parseInt(option)) {
            case 1 -> this.uiFactory.getShoppingListInterface().createShoppingList();
            case 2 -> this.uiFactory.getShoppingListInterface().selectShoppinglist();
        }
    }
}
