package aoc.helper.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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


    public int amountBagContains(){
        List<DirectedWeightedEdge<T>> edgesToChilds = this.edges.stream().filter(edge -> edge.getFromNode() == this).collect(Collectors.toList());
        int amount = 1;
        for (DirectedWeightedEdge<T> edgesToChild : edgesToChilds) {
            SimpleNode<T> childNode = (SimpleNode<T>) edgesToChild.getToNode();
            int newAdded = edgesToChild.getWeight() * childNode.amountBagContains();
            System.out.println(childNode +": "+ newAdded);
            amount += newAdded;
        }
        System.out.println("--");
        return amount;
    }
    public Set<SimpleNode<T>> getUniqueIndirectParents(){
        Set<SimpleNode<T>> parents = new HashSet<SimpleNode<T>>(this.getParents());
        for(int j= 0; j < 5; j++) {
            for (int i = 0; i < parents.size(); i++) {
                SimpleNode<T> parent = (SimpleNode<T>) parents.toArray()[i];
                parents.addAll(parent.getUniqueIndirectParents());
            }
        }
        return parents;
    }

    public List<SimpleNode<T>> getParents(){
        List<SimpleNode<T>> simpleNodeList = new LinkedList<>();

        List<DirectedWeightedEdge<T>> edgesToParents = this.edges.stream().filter(edge -> edge.getToNode() == this).collect(Collectors.toList());

        for (DirectedWeightedEdge<T> edge : edgesToParents) {
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
