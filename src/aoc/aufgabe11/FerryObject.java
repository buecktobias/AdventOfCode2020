package aoc.aufgabe11;

import java.util.List;

public abstract class FerryObject{
    public Vector2D position;

    public FerryObject(int x, int y){
        this.position = new Vector2D(x, y);
    }
    public abstract boolean isEmpty();
    public abstract boolean isOccupied();
    public abstract void changeState(List<FerryObject> adjacentObjects);
    public abstract FerryObject getCopy();
    public int getAdjacentOccupied(List<FerryObject> ferryObjectList){
        return (int) ferryObjectList.stream().filter(FerryObject::isOccupied).count();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "FerryObject{" +
                "x=" + this.position.getX() +
                ", y=" + this.position.getY() +
                ", empty = "+ isEmpty() +
                '}';
    }
}
