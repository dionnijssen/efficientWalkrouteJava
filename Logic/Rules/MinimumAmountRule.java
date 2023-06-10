package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

public class MinimumAmountRule extends BasicRule {
    private int minimumAmount;

    public MinimumAmountRule(Shoppinglist shoppingList, Article article, int minimumAmount) {
        super(shoppingList, article);

        this.minimumAmount = minimumAmount;
    }

    @Override
    public void apply(Orderrule orderrule) {
        if (orderrule.getAmount() >= this.minimumAmount) {
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
        this.reason = "Minimum amount of " + this.article.getName() + " has to be " + this.minimumAmount;
    }
}
