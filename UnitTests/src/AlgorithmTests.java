import Logic.Models.Rule;
import Logic.Models.Shoppinglist;
import Logic.Services.RuleService;
import MockData.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AlgorithmTests {
    @Test
    public void createWalkrouteFails() {
        // Arrange
        RuleService ruleService = new RuleService(new RuleHelperMock());
        Shoppinglist shoppinglist = MockData.getShoppinglist();
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(new Rule(1, "fail", 1, 50));

        // Act
        boolean isSuccess = ruleService.applyRules(rules, shoppinglist);

        // Assert
        assertEquals(false, isSuccess);
    }

    @Test
    public void createWalkrouteSucceeds() {
        // Arrange
        RuleService ruleService = new RuleService(new RuleHelperMock());
        Shoppinglist shoppinglist = MockData.getShoppinglist();
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(new Rule(1, "succeed", 1, 5));

        // Act
        boolean isSuccess = ruleService.applyRules(rules, shoppinglist);

        // Assert
        assertEquals(true, isSuccess);
    }

    @Test
    public void createWalkrouteWithoutActiveRules() {
        // Arrange
        RuleService ruleService = new RuleService(new RuleHelperMock());
        Shoppinglist shoppinglist = MockData.getShoppinglist();
        ArrayList<Rule> rules = new ArrayList<Rule>();

        // Act
        boolean isSuccess = ruleService.applyRules(rules, shoppinglist);

        // Assert
        assertEquals(true, isSuccess);
    }
}