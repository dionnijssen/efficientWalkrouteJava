package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Shoppinglist;

import java.util.ArrayList;

abstract class BasicRule {
    protected Shoppinglist shoppingList;
    protected Article article;
    protected int amount;
    protected boolean applied;

    public BasicRule(Shoppinglist shoppingList, Article article, int amount) {
        this.shoppingList = shoppingList;
        this.article = article;
        this.amount = amount;
        this.applied = false;

        this.setOptions();
        this.apply();
    }

    private void apply() {

    }

    public int priority() {
        return 1;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean hasBeenApplied() {
        return this.applied;
    }

    public String getReason() {
        return "";
    }

    private void setOptions() {
//        this.options = ;
    }

    public ArrayList getOptions() {
//        return this.options;
        return new ArrayList();
    }
}
