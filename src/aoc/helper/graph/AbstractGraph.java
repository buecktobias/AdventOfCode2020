package aoc.helper.graph;

import java.util.List;

public abstract class AbstractGraph <T> {
    public abstract List<AbstractNode<T>> getNodes();
}
