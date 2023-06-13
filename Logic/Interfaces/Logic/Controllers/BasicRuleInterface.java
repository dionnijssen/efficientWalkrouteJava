package Logic.Interfaces.Logic.Controllers;

import Logic.Dtos.src.RuleInformtionDto;
import Logic.Models.Orderrule;

public interface BasicRuleInterface {
    RuleInformtionDto apply(Orderrule orderrule,  Object... args);
}
