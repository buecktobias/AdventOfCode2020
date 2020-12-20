package aoc.tasks.task16;

import java.util.HashSet;
import java.util.Set;

public class TicketField {
    public Range range1;
    public Range range2;

    public TicketField(Range range1, Range range2) {
        this.range1 = range1;
        this.range2 = range2;
    }

    public Set<Integer> getCorrectValues(){
        Set<Integer> set = new HashSet<>();
        for(int i = range1.from; i <= range1.to; i++){
            set.add(i);
        }
        for(int i = range2.from; i <= range2.to; i++){
            set.add(i);
        }
        return set;
    }

    @Override
    public String toString() {
        return "TicketField{" +
                "range1=" + range1 +
                ", range2=" + range2 +
                '}';
    }
}
