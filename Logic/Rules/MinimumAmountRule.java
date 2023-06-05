package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Shoppinglist;

public class MinimumAmountRule extends BasicRule {
    private int amount;
    private String reason = null;
    private int minimumAmount;

    public MinimumAmountRule(Shoppinglist shoppingList, Article article, int minimumAmount) {
        super(shoppingList, article);

        this.minimumAmount = minimumAmount;
    }

    @Override
    public void apply() {
        if (this.amount >= this.minimumAmount) {
            this.applied = false;
            this.reason = "Success";

            return;
        }

        this.applied = true;
        this.reason = "Minimum amount raised to minimum amount of " + this.minimumAmount;
    }

    public boolean hasBeenApplied() {
        return this.applied;
    }

    @Override
    public String getReason() {
        return "Test";
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
