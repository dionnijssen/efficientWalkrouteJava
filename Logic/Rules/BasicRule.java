package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Shoppinglist;

import java.util.ArrayList;

abstract public class BasicRule {
    protected Shoppinglist shoppingList;
    protected Article article;
    protected int amount;
    protected boolean applied;

    public BasicRule(Shoppinglist shoppingList, Article article, int amount) {
        this.shoppingList = shoppingList;
        this.article = article;
        this.amount = amount;
        this.applied = false;
    }

    public abstract void apply();

    public boolean hasBeenApplied() {
        return this.applied;
    }

    public abstract void getReason();
}
