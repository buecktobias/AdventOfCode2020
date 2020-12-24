package aoc.tasks.task19;

public class TerminalRule extends Rule{
    char mChar;

    public TerminalRule(char mChar) {
        this.mChar = mChar;
    }

    @Override
    public int getAmountCharsMatched(String string) {
        if (string.charAt(0) == mChar) {
            return 1;
        }else{
            return 0;
        }
    }
}
