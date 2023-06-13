package Logic.Rules;

import Logic.Dtos.src.RuleInformtionDto;
import Logic.Interfaces.Logic.Controllers.BasicRuleInterface;
import Logic.Models.Article;
import Logic.Models.Orderrule;

public class MaximumAmountRule implements BasicRuleInterface {
    private int maxAmount;

    public RuleInformtionDto apply(Orderrule orderrule, Object... args) {
        RuleInformtionDto ruleInformation = new RuleInformtionDto();
        this.maxAmount = (Integer) args[0];

        if (orderrule.getAmount() <= this.maxAmount) {
            ruleInformation.setSucces();
            return ruleInformation;
        }

        Article article = orderrule.getArticle();
        String reason = "Max amount of " + article.getName() + " is " + this.maxAmount;
        ruleInformation.setFailure(reason);

        return ruleInformation;
    }
}
