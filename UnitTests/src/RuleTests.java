import Logic.Dtos.src.RuleInformtionDto;
import Logic.Models.Orderrule;
import Logic.Rules.MaximumAmountRule;
import Logic.Rules.MinimumAmountRule;
import MockData.MockData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RuleTests {
    @Test
    public void maximumAmountRuleFails() {
        // Arrange
        Orderrule orderrule = MockData.getOrderrule();

        // Act
        RuleInformtionDto ruleInformation = new MaximumAmountRule().apply(orderrule, 4);

        // Assert
        assertEquals(false, ruleInformation.isSuccess());
    }

    @Test
    public void maximumAmountRuleSucceeds() {
        // Arrange
        Orderrule orderrule = MockData.getOrderrule();

        // Act
        RuleInformtionDto ruleInformation = new MaximumAmountRule().apply(orderrule, 5);

        // Assert
        assertEquals(true, ruleInformation.isSuccess());
    }

    @Test
    public void minimumAmountRuleFails() {
        // Arrange
        Orderrule orderrule = MockData.getOrderrule();

        // Act
        RuleInformtionDto ruleInformation = new MinimumAmountRule().apply(orderrule, 10);

        // Assert
        assertEquals(false, ruleInformation.isSuccess());
    }

    @Test
    public void minimumAmountRuleSucceeds() {
        // Arrange
        Orderrule orderrule = MockData.getOrderrule();

        // Act
        RuleInformtionDto ruleInformation = new MinimumAmountRule().apply(orderrule, 5);

        // Assert
        assertEquals(true, ruleInformation.isSuccess());
    }
}
