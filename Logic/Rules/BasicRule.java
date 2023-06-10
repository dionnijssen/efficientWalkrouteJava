package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

abstract public class BasicRule {
    protected Shoppinglist shoppingList;
    protected Article article;
    protected int amount;
    protected boolean applied;
    protected String reason;

    public BasicRule(Shoppinglist shoppingList, Article article) {
        this.shoppingList = shoppingList;
        this.article = article;

        this.applied = false;
    }

    public abstract void apply(Orderrule orderrule);

    public boolean hasBeenApplied() {
        return this.applied;
    }

    public String getReason() {
        return this.reason;
    }

    public abstract void setReason();

    public Article getArticle() {
        return this.article;
    }
}
