package aoc.helper.graph;

import java.util.LinkedList;
import java.util.List;

public class SimpleNode<T> extends AbstractNode<T>{
    private T value;
    private List<DirectedWeightedEdge<T>>  edges;

    public SimpleNode(T value) {
        this.edges = new LinkedList<>();
        this.value = value;
    }

    public void addEdge(DirectedWeightedEdge<T> newEdge){
        this.edges.add(newEdge);
    }

    public List<SimpleNode<T>> getParents(){
        List<SimpleNode<T>> simpleNodeList = new LinkedList<>();
        for (DirectedWeightedEdge<T> edge : this.edges) {
            simpleNodeList.add((SimpleNode<T>) edge.getFromNode());
        }
        return simpleNodeList;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T t) {
        this.value = t;
    }

    @Override
    public String toString() {
        return "SimpleNode{" +
                "value=" + value +
                '}';
    }
}
