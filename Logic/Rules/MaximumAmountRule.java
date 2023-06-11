package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Orderrule;

public class MaximumAmountRule extends BasicRule {
    private int maxAmount;

    @Override
    public void apply(Orderrule orderrule, Object... args) {
        this.maxAmount = (Integer) args[0];

        if (orderrule.getAmount() <= this.maxAmount) {
            this.applied = false;
            this.reason = "Success";

            return;
        }

        this.applied = true;

        Article article = orderrule.getArticle();
        this.setReason(article);
    }

    public boolean hasBeenApplied() {
        return this.applied;
    }

    public void setReason(Article article) {
        this.reason = "Max amount of "+ article.getName() +" is " + this.maxAmount;
    }
}
