package aoc.helper.graph;

import java.util.HashMap;
import java.util.List;

public class DirectedWeightedGraph<T> extends AbstractGraph<T> {
    private HashMap<T, SimpleNode<T>> nodes;

    public DirectedWeightedGraph() {
        nodes = new HashMap<>();
    }

    public void addNode(T newNode){
        if(!nodes.containsKey(newNode)) {
            nodes.put(newNode, new SimpleNode<>(newNode));
        }
    }

    public void addEdge(T fromNode, T toNode, int weight){
        DirectedWeightedEdge<T> edge = new DirectedWeightedEdge<T>(weight, this.getNode(fromNode), this.getNode(toNode));
        this.getNode(fromNode).addEdge(edge);
        this.getNode(toNode).addEdge(edge);
    }

    public SimpleNode<T> getNode(T identifier){
        return this.nodes.get(identifier);
    }

    @Override
    public String toString() {
        return "DirectedWeightedGraph{" +
                "nodes=" + nodes +
                '}';
    }
}
