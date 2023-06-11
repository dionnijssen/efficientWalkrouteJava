package Logic.Helpers;

import Logic.Rules.BasicRule;
import Logic.Rules.MaximumAmountRule;
import Logic.Rules.MinimumAmountRule;

public class RuleHelper {
    public static BasicRule getCorrectRule(String type) {
        switch (type) {
            case "max":
                return new MaximumAmountRule();
            case "min":
                return new MinimumAmountRule();
            default:
                throw new IllegalArgumentException("Invalid rule type");
        }
    }
}
