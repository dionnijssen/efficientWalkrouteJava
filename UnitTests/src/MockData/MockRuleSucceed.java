package MockData;

import Logic.Dtos.src.RuleInformtionDto;
import Logic.Interfaces.Logic.Controllers.BasicRuleInterface;
import Logic.Models.Orderrule;

public class MockRuleSucceed implements BasicRuleInterface
{
    public RuleInformtionDto apply(Orderrule orderrule, Object... args) {
        RuleInformtionDto ruleInformation = new RuleInformtionDto();
        ruleInformation.setSuccess();
        return ruleInformation;
    }
}
