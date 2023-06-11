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

    /*
        - Voeg test toe van (meerdere) Orders toevoegen aan shoppingList
        - Voeg test toe van Algoritme
     */

    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.main();
    }

    public void main() throws IOException, ParseException {
        this.repositoryFactory = new RepositoryFactory();
        this.serviceFactory = new ServiceFactory();
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
            case 1 -> this.createOrder(shoppinglist);
            case 2 -> this.selectOrder(shoppinglist);
            case 3 -> this.createWalkroute(shoppinglist);
            case 4 -> this.showWalkRoute(shoppinglist);
        }
    }

    private void selectOrder(Shoppinglist shoppinglist) throws IOException, ParseException {
        System.out.println("");
        System.out.println("Select an order:");

        Order selectedOrder = null;

        try {
            ArrayList orderOptions = new ArrayList<>();
            ArrayList<Order> orders = shoppinglist.getOrders();

            if (orders.size() == 0) {
                throw new RuntimeException("No orders found");
            }

            int count = 1;
            for (Order order : orders) {
                System.out.println(count + " " + order.getId());
                orderOptions.add(Integer.toString(order.getId()));
                count++;
            }
            orderOptions.add(Integer.toString(count));
            System.out.println(count + " Back");
            String selected = Helpers.readOption(orderOptions);

            if (selected.equals(Integer.toString(count))) {
                shoppingListOptions(shoppinglist);
            }

            int selectedOrderId = Integer.parseInt(selected);
            for (Order order : orders) {
                if (order.getId() == selectedOrderId) {
                    selectedOrder = order;
                }
            }

//            selectedOrder = this.controllerFactory.getOrderController().show(Integer.parseInt(selected));
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            shoppingListOptions(shoppinglist);
        }

        selectOrderrule(shoppinglist, selectedOrder);
    }

    private void selectOrderrule(Shoppinglist shoppinglist, Order order) throws IOException, ParseException {
        System.out.println("");
        System.out.println("Select an orderline:");

        Orderrule selectedOrderrule = null;

        try {
            ArrayList orderOptions = new ArrayList<>();
            ArrayList<Orderrule> orderrules = order.getOrderrules();

            if (orderrules.size() == 0) {
                throw new RuntimeException("No orderrules found");
            }

            int count = 0;
            for (int i = 0; i < orderrules.size(); i++) {
                System.out.println(i + " " + orderrules.get(i).getArticle().getName());
                orderOptions.add(Integer.toString(i));

                count++;
            }

            orderOptions.add(Integer.toString(count));
            System.out.println(count + " Back");

            String selected = Helpers.readOption(orderOptions);

            if (selected.equals(Integer.toString(count))) {
                shoppingListOptions(shoppinglist);
            }

            selectedOrderrule = orderrules.get(Integer.parseInt(selected));
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            shoppingListOptions(shoppinglist);
        }

        updateOrderrule(shoppinglist, order, selectedOrderrule);
    }

    private void updateOrderrule(Shoppinglist shoppinglist, Order order, Orderrule orderrule) throws IOException, ParseException {
        System.out.println("");
        System.out.println("Set amount");

        int amount = Helpers.readInt();

        if (amount == 0) {
            for (int i = 0; i < order.getOrderrules().size(); i++) {
                if (order.getOrderrules().get(i).getArticle().getId() == orderrule.getArticle().getId()) {
                    order.getOrderrules().remove(i);
                }
            }
        }

        orderrule.setAmount(amount);
        System.out.println("Amount updated!");

        //Check if it is updated
        shoppingListOptions(shoppinglist);
    }

    private void createWalkroute(Shoppinglist shoppinglist) throws IOException, ParseException {
        if (shoppinglist.getOrders() == null) {
            System.out.println();
            System.out.println("No orders found for this shoppinglist");
            this.shoppingListOptions(shoppinglist);
        }

        shoppinglist = this.controllerFactory.getWalkrouteManager().createWalkRoute(shoppinglist);

        this.shoppingListOptions(shoppinglist);
    }

    private void showWalkRoute(Shoppinglist shoppinglist) throws IOException, ParseException {
        if (shoppinglist.getWalkRouteId() == 0) {
            System.out.println();
            System.out.println("No walkroute found for this shoppinglist");
            this.shoppingListOptions(shoppinglist);
        }

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

        ArrayList<Orderrule> orderrules = new ArrayList<>();
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

            if (amount == 0) {
                System.out.println("Amount cannot be 0");
                continue;
            }
            boolean articleExists = false;
            // Check if article is already in orderrules
            for (Orderrule rule : orderrules) {
                if (rule.getArticle().getId() == article.getId()) {
                    rule.setAmount(rule.getAmount() + amount);
                    articleExists = true;
                }
            }

            if (!articleExists) {
                orderrules.add(new Orderrule(article, amount));
            }

            System.out.println("");
            System.out.println("Current articles:");

            for (Orderrule rule : orderrules) {
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

        for (Orderrule orderrule : orderrules) {
            updatedOrder = this.controllerFactory.getOrderManager().addToOrder(order, orderrule);
        }

        return updatedOrder;
    }
}

