package aoc.helper.graph;

public class DirectedWeightedEdge <T> extends AbstractEdge<T>{
    private int weight;
    private AbstractNode<T> fromNode;
    private AbstractNode<T> toNode;

    public DirectedWeightedEdge(int weight, AbstractNode<T> fromNode, AbstractNode<T> toNode) {
        this.weight = weight;
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    public int getWeight() {
        return weight;
    }

    public AbstractNode<T> getFromNode() {
        return fromNode;
    }

    public AbstractNode<T> getToNode() {
        return toNode;
    }
}
