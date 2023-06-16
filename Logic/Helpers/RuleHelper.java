package Logic.Helpers;

import Logic.Interfaces.Logic.Controllers.BasicRuleInterface;
import Logic.Interfaces.Logic.Controllers.RuleHelperInterface;
import Logic.Rules.MaximumAmountRule;
import Logic.Rules.MinimumAmountRule;

public class RuleHelper implements RuleHelperInterface {
    public BasicRuleInterface getCorrectRule(String type) {
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
