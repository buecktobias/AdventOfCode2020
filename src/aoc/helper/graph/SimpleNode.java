package aoc.helper.graph;

public class SimpleNode<T> extends AbstractNode<T>{
    private T value;

    public SimpleNode(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T t) {
        this.value = t;
    }
}
