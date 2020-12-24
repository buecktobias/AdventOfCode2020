package aoc.tasks.task18;

public class Add extends Operator{
    @Override
    public long calculate(long n1, long n2) {
        return n1 + n2;
    }

    @Override
    public int getPrecedence() {
        return 2;
    }
}
