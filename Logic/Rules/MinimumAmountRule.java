package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Shoppinglist;

public class MinimumAmountRule extends BasicRule {
    public MinimumAmountRule(Shoppinglist shoppingList, Article article, int amount) {
        super(shoppingList, article, amount);
    }

    private void apply() {
//        if (this.amount < this.settings.get("min")) {
//            this.amount = this.settings.get("min");
//            this.applied = true;
//        }
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

//    private void setOptions()
//    {
//        this.options = [
//                'min' => 'int',
//        ];
//    }
//
//    private void apply()
//    {
//        if (this.amount < this.settings['min']) {
//            this.amount = this.settings['min'];
//            this.applied = true;
//        }
//    }
//
//    public int priority()
//    {
//        return 1;
//    }
//
//    public String getReason()
//    {
//        if (this.applied) {
//            return 'Raised to minimum amount';
//        }
//
//        return null;
//    }
}
