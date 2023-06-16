package MockData;

import Logic.Interfaces.Logic.Controllers.BasicRuleInterface;
import Logic.Interfaces.Logic.Controllers.RuleHelperInterface;

public class RuleHelperMock implements RuleHelperInterface {
    public BasicRuleInterface getCorrectRule(String type) {
        switch (type) {
            case "succeed":
                return new MockRuleSucceed();
            case "fail":
                return new MockRuleFail();
            default:
                throw new IllegalArgumentException("Invalid rule type");
        }
    }
}
