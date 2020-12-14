package aoc.tasks.task11;

import java.util.List;

public class Floor extends FerryObject{

    public Floor(int x, int y) {
        super(x, y);
    }

    @Override
    public void changeState2(Ferry ferry) {

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
        return new Floor(this.position.getX(), this.position.getY());
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
