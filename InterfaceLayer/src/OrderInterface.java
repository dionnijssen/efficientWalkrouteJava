package src;

import Logic.ControllerFactory;
import Logic.Helpers.Helpers;
import Logic.Models.Article;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;
import Logic.UiFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class OrderInterface {
    private ControllerFactory controllerFactory;
    private UiFactory uiFactory;

    public OrderInterface(
            ControllerFactory controllerFactory,
            UiFactory uiFactory
    ) {
        this.controllerFactory = controllerFactory;
        this.uiFactory = uiFactory;
    }

    public void selectOrder(Shoppinglist shoppinglist) throws IOException, ParseException {
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
                this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
            }

            int selectedOrderId = Integer.parseInt(selected);
            for (Order order : orders) {
                if (order.getId() == selectedOrderId) {
                    selectedOrder = order;
                }
            }

        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
        }

        selectOrderrule(shoppinglist, selectedOrder);
    }

    public void selectOrderrule(Shoppinglist shoppinglist, Order order) throws IOException, ParseException {
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
                this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
            }

            selectedOrderrule = orderrules.get(Integer.parseInt(selected));
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
        }

        updateOrderrule(shoppinglist, order, selectedOrderrule);
    }

    public void updateOrderrule(Shoppinglist shoppinglist, Order order, Orderrule orderrule) throws IOException, ParseException {
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

        this.uiFactory.getShoppingListInterface().shoppingListOptions(shoppinglist);
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
        this.uiFactory.getShoppingListInterface().shoppingListOptions(updatedShoppingList);
    }

    public Order addArticlesToOrder(Order order) throws IOException {
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
