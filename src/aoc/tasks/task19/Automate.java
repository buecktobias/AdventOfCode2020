package aoc.tasks.task19;

public class Automate {


    public static boolean buildTestRules(){
        NonTerminalRule nonTerminalRule = new NonTerminalRule();
        TerminalRule terminalRule = new TerminalRule('a');
        nonTerminalRule.addSubRule(0, terminalRule);
        nonTerminalRule.addSubRule(0, terminalRule);
        NonTerminalRule nonTerminalRule1 = new NonTerminalRule();
        nonTerminalRule1.addSubRule(0, nonTerminalRule);
        nonTerminalRule1.addSubRule(1, terminalRule);
        return 1 == nonTerminalRule1.getAmountCharsMatched("a");
    }
}
