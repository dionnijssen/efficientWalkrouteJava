package Logic.Controllers;

import DataLayer.ArticleRepository;
import DataLayer.ShoppinglistRepository;
import Logic.Helpers.Helpers;
import Logic.Interfaces.OrderManagerInterface;
import Logic.Models.Article;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

import java.io.IOException;
import java.util.ArrayList;

public class OrderManager implements OrderManagerInterface {

    private ShoppinglistRepository shoppinglistRepository;
    private ArticleRepository articleRepository;

    public OrderManager(ShoppinglistRepository shoppinglistRepository, ArticleRepository articleRepository) {
        this.shoppinglistRepository = shoppinglistRepository;
        this.articleRepository = articleRepository;
    }

    public Order addArticlesToOrder(Order order) throws IOException {
        ArrayList articleOptions = new ArrayList<>();
        boolean firstTime = true;
        boolean again = true;
        Order updatedOrder = null;

        do {
            for (Article article : this.articleRepository.get()) {
                if (firstTime) {
                    articleOptions.add(Integer.toString(article.id));
                }
                System.out.println(article.id + ". " + article.name + " , " + article.description);
            }

            String select = Helpers.readOption(articleOptions);
            Article article = this.articleRepository.show(Integer.parseInt(select));

            System.out.println("Amount?");
            int amount = Helpers.readInt();

            Orderrule orderrule = new Orderrule(article, amount);

            updatedOrder = this.addToOrder(order, orderrule);

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

    public Order addToOrder(Order order, Orderrule orderrule) {
//        if (order.orderrules == null) {
//            ArrayList<Orderrule> orderrules = new ArrayList<Orderrule>();
//            orderrules.add(orderrule);
//            order.orderrules = orderrules;
//        } else {
        order.orderrules.add(orderrule);
//        }

        return order;
    }

    public boolean storeOrder(Shoppinglist shoppinglist, Order order) {
        try {
            for (Shoppinglist list : this.shoppinglistRepository.get()) {
                if (list.id == shoppinglist.id) {
                    if (shoppinglist.orders == null) {
                        ArrayList<Order> orders = new ArrayList<Order>();
                        orders.add(order);
                        shoppinglist.orders = orders;
                    } else {
                        shoppinglist.orders.add(order);
                    }
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Shoppinglist addOrderToShoppingList(Shoppinglist shoppinglist, Order order) {
        shoppinglist.orders.add(order);
        Shoppinglist updatedShoppingList = this.shoppinglistRepository.update(shoppinglist);

        if (updatedShoppingList != null) {
            System.out.println("Order added to shoppinglist");

            return updatedShoppingList;
        } else {
            System.out.println("Something went wrong, please try again");

            throw new RuntimeException("Something went wrong, please try again");
        }
    }

    public boolean removeFromOrder(Order order, Article article, int amount) {
        return false;
    }
}
