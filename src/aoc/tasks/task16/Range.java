package aoc.tasks.task16;

public class Range {
    public int from;
    public int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Range{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
