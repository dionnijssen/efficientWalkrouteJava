package DataLayer;

import Logic.Models.Rule;

import java.util.ArrayList;

public class RuleRepository {
    private ArrayList<Rule> rules;

    public RuleRepository() {
        this.rules = new ArrayList<Rule>();

        this.rules.add(new Rule(1, "max", 1, 2));
        this.rules.add(new Rule(2, "min", 2, 5));
    }

    public ArrayList<Rule> get() {
        return this.rules;
    }
}
