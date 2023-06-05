import Logic.ControllerFactory;
import Logic.Helpers.Helpers;
import Logic.Models.*;
import Logic.RepositoryFactory;
import Logic.ServiceFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    private ControllerFactory controllerFactory;
    private RepositoryFactory repositoryFactory;
    private ServiceFactory serviceFactory;

    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.main();
    }

    public void main() throws IOException, ParseException {
        this.repositoryFactory = new RepositoryFactory();
        this.serviceFactory = new ServiceFactory(this.repositoryFactory);
        this.controllerFactory = new ControllerFactory(this.repositoryFactory, this.serviceFactory);

        this.start();
    }

    public void start() throws IOException, ParseException {
        System.out.println("");
        System.out.println("Select action:");
        System.out.println("1. Create shoppinglist for today");
        System.out.println("2. Shoppinglist options");

        ArrayList<String> options = new ArrayList<String>();
        options.add("1");
        options.add("2");

        String option = Helpers.readOption(options);

        switch (Integer.parseInt(option)) {
            case 1 -> this.createShoppingList();
            case 2 -> this.selectShoppinglist();
        }
    }

    public void createShoppingList() throws IOException, ParseException {
        Boolean success = this.controllerFactory.getShoppinglistController().create();

        if (success) {
            System.out.println("Shoppinglist created");
        } else {
            System.out.println("Something went wrong, please try again");

            throw new RuntimeException("Something went wrong, please try again");
        }
        start();
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
            start();
        }


        shoppingListOptions(selectedShoppinglist);
    }

    public void shoppingListOptions(Shoppinglist shoppinglist) throws IOException, ParseException {
        System.out.println("");
        System.out.println("Shoppinglist actions:");
        System.out.println("1. Create order");
        System.out.println("2. TODO?: Order actions");
        System.out.println("3. Create Walkroute");
        System.out.println("4. Show Walkroute");

        ArrayList<String> options = new ArrayList<String>();
        options.add("1");
        options.add("2");
        options.add("3");
        options.add("4");

        String option = Helpers.readOption(options);

        switch (Integer.parseInt(option)) {
            case 1 -> this.createOrder(shoppinglist);
//            case 2 -> this.selectShoppinglist(this.controllerFactory.getShoppinglistController(), this.controllerFactory.getOrderController());
            case 3 -> this.createWalkroute(shoppinglist);
            case 4 -> this.showWalkRoute(shoppinglist);
        }
    }

    private void createWalkroute(Shoppinglist shoppinglist) throws IOException, ParseException {
        if (shoppinglist.getOrders() == null) {
            System.out.println();
            System.out.println("No orders found for this shoppinglist");
            this.shoppingListOptions(shoppinglist);
        }

        this.controllerFactory.getWalkrouteManager().createWalkRoute(shoppinglist);

        this.shoppingListOptions(shoppinglist);
    }

    private void showWalkRoute(Shoppinglist shoppinglist) throws IOException, ParseException {
        WalkRoute walkRoute = this.repositoryFactory.getWalkRouteRepository().show(shoppinglist.getWalkRouteId());

        System.out.println("");
        System.out.println("Walkroute for shoppinglist " + shoppinglist.getId() + " on " + shoppinglist.getDate());
        for (Article article : walkRoute.getWalkroute()) {
            int amount = this.controllerFactory.getWalkrouteManager().getShoppingListArticleAmount(shoppinglist, article);

            System.out.println(article.getName() + " " + article.getDescription() + " " + amount);
        }
        System.out.println();
        System.out.println("End of walkroute");

        this.shoppingListOptions(shoppinglist);
    }

    public void createOrder(Shoppinglist shoppinglist) throws IOException, ParseException {
        Order order = this.controllerFactory.getOrderController().create();

        // Add articles to order
        System.out.println("");
        System.out.println("Choose articles to add to order.");
        Order updatedOrder = this.addArticlesToOrder(order);

        // Add order to shoppinglist
        System.out.println("");
        System.out.println("Adding order to shoppinglist...");

        Shoppinglist updatedShoppingList = this.controllerFactory.getOrderManager().addOrderToShoppingList(shoppinglist, order);

        System.out.println("");
        System.out.println("Order added to shoppinglist.");

        // Back to shoppinglist Options
        shoppingListOptions(updatedShoppingList);
    }

    private Order addArticlesToOrder(Order order) throws IOException {
        ArrayList articleOptions = new ArrayList();
        boolean firstTime = true;
        boolean again = true;
        Order updatedOrder = null;

        do {
            for (Article article : this.controllerFactory.getArticleController().get()) {
                if (firstTime) {
                    articleOptions.add(Integer.toString(article.getId()));
                }
                System.out.println(article.getId() + ". " + article.getName() + " , " + article.getDescription());
            }

            String select = Helpers.readOption(articleOptions);
            Article article = this.controllerFactory.getArticleController().show(Integer.parseInt(select));

            System.out.println("Amount?");
            int amount = Helpers.readInt();

            Orderrule orderrule = new Orderrule(article, amount);

            updatedOrder = this.controllerFactory.getOrderManager().addToOrder(order, orderrule);

            System.out.println("");
            System.out.println("Current articles:");

            for (Orderrule rule : updatedOrder.getOrderrules()) {
                System.out.println(rule.getArticle().getName() + ", " + rule.getAmount());
            }
            System.out.println("");

            System.out.println("Select action:");
            System.out.println("1. Add another article");
            System.out.println("2. Submit Order");

            ArrayList addAnotherArticle = new ArrayList<>();

            addAnotherArticle.add("1");
            addAnotherArticle.add("2");

            String option = Helpers.readOption(addAnotherArticle);

            firstTime = false;

            switch (Integer.parseInt(option)) {
                case 1 -> again = true;
                case 2 -> again = false;
            }
        } while (again);

        return updatedOrder;
    }
}

