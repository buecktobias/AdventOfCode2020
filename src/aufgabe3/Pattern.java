package aufgabe3;

import java.util.Arrays;

public class Pattern {
    private final FieldObject[][] fieldObjects;

    public Pattern(FieldObject[][] fieldObjects){
        this.fieldObjects = fieldObjects;
    }

    public FieldObject[][] getFieldObjects() {
        return fieldObjects;
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "fieldObjects=" + Arrays.toString(fieldObjects) +
                '}';
    }
}
