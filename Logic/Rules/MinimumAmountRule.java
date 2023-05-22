package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Shoppinglist;

public class MinimumAmountRule extends BasicRule {
    private int minimumAmount;
    private String reason = null;

    public MinimumAmountRule(Shoppinglist shoppingList, Article article, int amount) {
        super(shoppingList, article, amount);
    }

    @Override
    public void apply() {
        if (this.amount >= this.minimumAmount) {
            this.applied = false;
            this.reason = "Success";

            return;
        }

        this.amount = this.minimumAmount;
        this.applied = true;
        this.reason = "Minimum amount raised to minimum amount of " + this.minimumAmount;
    }

    public boolean hasBeenApplied() {
        return this.applied;
    }

    public String getReason() {
        return "";
    }
}
