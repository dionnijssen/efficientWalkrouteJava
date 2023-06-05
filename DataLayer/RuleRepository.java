package DataLayer;

import Logic.Interfaces.Data.RepositoryInterface;
import Logic.Models.Rule;
import Logic.Models.WalkRoute;

import java.util.ArrayList;

public class RuleRepository  {
    private ArrayList<Rule> rules;

    public RuleRepository() {
        this.rules = new ArrayList<Rule>();

        this.rules.add(new Rule(1, "min", 1, 2));
        this.rules.add(new Rule(2, "min", 2, 500));
    }

    public ArrayList<Rule> get() {
        return this.rules;
    }
}
