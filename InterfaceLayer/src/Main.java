import Logic.ControllerFactory;
import Logic.Helpers.Helpers;
import Logic.Models.Article;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;
import Logic.RepositoryFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    /* Besproken met John
    - Main gebruiken voor de flow van de applicatie. De rest uitbesteden aan de controllers en repos (repos in de controller).
    - Class App waarin alle static dingen die hier gedeclareerd zijn, daarin zetten. En waar dat hier gebruikt is verwijzen naar App.Java
    - Database renamen naar RepositoryFactory
        - Database is de frontend voor de Datalayer repositories. Het is enkel nodig om deze op te kunnen halen.
    - De Repositories in de controllers injecteren, ipv instantiëren in de constructor.
    In de main heb je de mogelijkheid om de echte repos en controllers bij elkaar te brengen. Of in de UnitTest.
    - De constructors van de controllers zo centraal mogelijk aanmaken zodat je niet de benodigde parameters overal aan moet passen mocht dit ooit uitgebreid worden.
    - Documenten opnieuw uploaden -> in Sprint 1,2,3
     */
    private ControllerFactory controllerFactory;
    private RepositoryFactory repositoryFactory;

    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.main();
    }

    public void main() throws IOException, ParseException {
        this.repositoryFactory = new RepositoryFactory();
        this.controllerFactory = new ControllerFactory(repositoryFactory);

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
                System.out.println(count + " " + shoppinglist.date);
                shoppinglistOptions.add(Integer.toString(shoppinglist.id));
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
        System.out.println("3. TODO: Create Walkroute");

        ArrayList<String> options = new ArrayList<String>();
        options.add("1");
        options.add("2");
        options.add("3");

        String option = Helpers.readOption(options);

        switch (Integer.parseInt(option)) {
            case 1 -> this.createOrder(shoppinglist);
//            case 2 -> this.selectShoppinglist(this.controllerFactory.getShoppinglistController(), this.controllerFactory.getOrderController());
//            case 3 -> this.listShoppingLists(this.controllerFactory.getShoppinglistController());
        }
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
                    articleOptions.add(Integer.toString(article.id));
                }
                System.out.println(article.id + ". " + article.name + " , " + article.description);
            }

            String select = Helpers.readOption(articleOptions);
            Article article = this.controllerFactory.getArticleController().show(Integer.parseInt(select));

            System.out.println("Amount?");
            int amount = Helpers.readInt();

            Orderrule orderrule = new Orderrule(article, amount);

            updatedOrder = this.controllerFactory.getOrderManager().addToOrder(order, orderrule);

            System.out.println("");
            System.out.println("Current articles:");

            for (Orderrule rule : updatedOrder.orderrules) {
                System.out.println(rule.article.name + ", " + rule.amount);
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

    //TODO: Tests
}

