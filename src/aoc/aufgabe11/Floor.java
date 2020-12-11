package aoc.aufgabe11;

import java.util.List;

public class Floor extends FerryObject{

    public Floor(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Floor;
    }

    @Override
    public FerryObject getCopy() {
        return new Floor(this.x, this.y);
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public void changeState(List<FerryObject> ferryObjectList) {
        // The floor does not change
    }

    @Override
    public String toString() {
        return ".";
    }
}
