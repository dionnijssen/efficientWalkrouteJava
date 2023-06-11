package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Orderrule;

abstract public class BasicRule {
    protected boolean applied;
    protected String reason;

    public BasicRule() {
        this.applied = false;
    }

    public abstract void apply(Orderrule orderrule, Object... args);

    public boolean hasBeenApplied() {
        return this.applied;
    }

    public String getReason() {
        return this.reason;
    }

    public abstract void setReason(Article article);
}
