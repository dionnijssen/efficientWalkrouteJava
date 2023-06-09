package src;

import Logic.ControllerFactory;
import Logic.Models.Article;
import Logic.Models.Shoppinglist;
import Logic.Models.WalkRoute;
import Logic.RepositoryFactory;
import Logic.UiFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class WalkrouteInterface {
    private ControllerFactory controllerFactory;
    private RepositoryFactory repositoryFactory;
    private UiFactory uiFactory;

    public WalkrouteInterface(ControllerFactory controllerFactory, RepositoryFactory repositoryFactory, UiFactory uiFactory) {
        this.controllerFactory = controllerFactory;
        this.repositoryFactory = repositoryFactory;
        this.uiFactory = uiFactory;
    }

    public void createWalkroute(Shoppinglist shoppinglist) throws IOException, ParseException {
        if (shoppinglist.getOrders() == null) {
            System.out.println();
            System.out.println("No orders found for this shoppinglist");
            this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
        }

        shoppinglist = this.controllerFactory.getWalkrouteManager().createWalkRoute(shoppinglist);

        if (shoppinglist.getWalkRouteId() == 0) {
            System.out.println();
            System.out.println("Failed to create walkroute");
        }

        this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
    }

    public void showWalkRoute(Shoppinglist shoppinglist) throws IOException, ParseException {
        if (shoppinglist.getWalkRouteId() == 0) {
            System.out.println();
            System.out.println("No walkroute found for this shoppinglist");
            this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
        }

        WalkRoute walkRoute = this.repositoryFactory.getWalkRouteRepository().show(shoppinglist.getWalkRouteId());

        System.out.println("");
        System.out.println("Walkroute for shoppinglist " + shoppinglist.getId() + " on " + shoppinglist.getDate());

        ArrayList<Article> articles = walkRoute.getWalkroute();

        // Remove duplicated articles
        for (int i = 0; i < articles.size(); i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getId() == articles.get(j).getId()) {
                    articles.remove(j);
                }
            }
        }

        for (Article article : articles) {
            int amount = this.controllerFactory.getWalkrouteManager().getShoppingListArticleAmount(shoppinglist, article);

            System.out.println(article.getName() + " " + article.getDescription() + " " + amount);
        }
        System.out.println();
        System.out.println("End of walkroute");

        this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
    }
}
