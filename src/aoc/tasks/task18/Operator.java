package aoc.tasks.task18;

public abstract class Operator {
    public abstract long calculate(long n1, long n2);
    public abstract int getPrecedence();
}
