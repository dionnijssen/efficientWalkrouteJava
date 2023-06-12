import Logic.Models.Rule;
import Logic.Models.Shoppinglist;
import Logic.Services.CreateWalkRouteService;
import MockData.MockData;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Algorithm {

    @Test
    public void createWalkrouteFails() {
        // Arrange
        CreateWalkRouteService createWalkRouteService = new CreateWalkRouteService();
        Shoppinglist shoppinglist = MockData.getShoppinglist();
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(new Rule(1, "min", 1, 50));

        // Act
        boolean isSuccess = createWalkRouteService.applyRules(rules, shoppinglist);

        // Assert
        assertEquals(false, isSuccess);
    }

    @Test
    public void createWalkrouteSucceeds() {
        // Arrange
        CreateWalkRouteService createWalkRouteService = new CreateWalkRouteService();
        Shoppinglist shoppinglist = MockData.getShoppinglist();
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(new Rule(1, "min", 1, 5));

        // Act
        boolean isSuccess = createWalkRouteService.applyRules(rules, shoppinglist);

        // Assert
        assertEquals(true, isSuccess);
    }
}