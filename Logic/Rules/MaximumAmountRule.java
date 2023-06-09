package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public class MaximumAmountRule extends BasicRule {
    private int amount;
    private int maxAmount;

    public MaximumAmountRule(Shoppinglist shoppingList, Article article, int maxAmount) {
        super(shoppingList, article);

        this.maxAmount = maxAmount;
    }

    @Override
    public void apply(Orderrule orderrule) {
        if (orderrule.getAmount() < this.maxAmount) {
            this.applied = false;
            this.reason = "Success";

            return;
        }

        this.applied = true;
        this.setReason();
    }

    public boolean hasBeenApplied() {
        return this.applied;
    }

    public void setReason() {
        this.reason = "Max amount of "+ this.article.getName() +" is " + this.maxAmount;
    }
}
