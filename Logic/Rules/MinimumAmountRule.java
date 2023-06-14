package Logic.Rules;

import Logic.Dtos.src.RuleInformtionDto;
import Logic.Interfaces.Logic.Controllers.BasicRuleInterface;
import Logic.Models.Article;
import Logic.Models.Orderrule;

public class MinimumAmountRule implements BasicRuleInterface {
    public RuleInformtionDto apply(Orderrule orderrule, Object... args) {
        RuleInformtionDto ruleInformation = new RuleInformtionDto();
        Integer minimumAmount = (Integer) args[0];

        if (orderrule.getAmount() >= minimumAmount) {
            ruleInformation.setSucces();
            return ruleInformation;
        }

        Article article = orderrule.getArticle();
        String reason = "Minimum amount of " + article.getName() + " has to be " + minimumAmount;
        ruleInformation.setFailure(reason);

        return ruleInformation;
    }
}
