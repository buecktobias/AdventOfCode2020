package aoc.tasks.task19;

import java.util.LinkedList;
import java.util.List;

public class NonTerminalRule extends Rule{
    public List<List<Rule>> subRules;

    public NonTerminalRule() {
        this.subRules = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            subRules.add(new LinkedList<>());
        }
    }

    public NonTerminalRule(List<List<Rule>> subRules) {
        this.subRules = subRules;
    }

    public void addSubRule(int option, Rule newRule){
        this.subRules.get(option).add(newRule);
    }

    @Override
    public int getAmountCharsMatched(String leftString) {
        int max = 0;
        for (List<Rule> ruleList : subRules) {
            if (matches(leftString, ruleList) > max){
                max = matches(leftString, ruleList);
            }
        }
        return max;
    }

    public int matches(String leftString, List<Rule> rules){
        int sumMatched = 0;
        for (Rule rule : rules) {
            if (sumMatched < leftString.length()) {
                sumMatched += rule.getAmountCharsMatched(leftString.substring(sumMatched));
            }else{
                return 0;
            }
        }
        return sumMatched;
    }
}
