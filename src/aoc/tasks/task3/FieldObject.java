package aoc.tasks.task3;

public abstract class FieldObject {
    public abstract boolean isTree();

    @Override
    public String toString() {
        return "FieldObject{" + this.isTree() + "}";
    }
}
