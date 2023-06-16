package MockData;

import Logic.Dtos.src.RuleInformtionDto;
import Logic.Interfaces.Logic.Controllers.BasicRuleInterface;
import Logic.Models.Orderrule;

public class MockRuleFail implements BasicRuleInterface
{
    public RuleInformtionDto apply(Orderrule orderrule, Object... args) {
        RuleInformtionDto ruleInformation = new RuleInformtionDto();
        ruleInformation.setFailure("MockRuleFail");
        return ruleInformation;
    }
}
