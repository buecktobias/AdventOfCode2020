package aoc.tasks.task3;

import java.util.Arrays;

public class Pattern {
    private final FieldObject[][] fieldObjects;

    public Pattern(FieldObject[][] fieldObjects){
        this.fieldObjects = fieldObjects;
    }

    public FieldObject[][] getFieldObjects() {
        return fieldObjects;
    }

    public int getWidth(){
        return this.fieldObjects[0].length;
    }
    public int getheight(){
        return this.fieldObjects.length;
    }

    public FieldObject getObjectAt(int x, int y){
        return this.fieldObjects[y][x];
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "fieldObjects=" + Arrays.toString(fieldObjects) +
                '}';
    }
}
