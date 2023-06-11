package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Orderrule;

public class MinimumAmountRule extends BasicRule {
    private int minimumAmount;

    @Override
    public void apply(Orderrule orderrule, Object... args) {
        this.minimumAmount = (Integer) args[0];

        if (orderrule.getAmount() >= this.minimumAmount) {
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
        this.reason = "Minimum amount of " + article.getName() + " has to be " + this.minimumAmount;
    }
}
