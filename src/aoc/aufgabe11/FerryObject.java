package aoc.aufgabe11;

import aoc.helper.Vector2D;

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

    public abstract void changeState2(Ferry ferry);

    public int getOccupiedInSight(Ferry ferry){
        List<Vector2D> directions = Directions.getDirections();
        int occupied = 0;
        for (Vector2D direction : directions) {
            Vector2D start = this.position.addVector(direction);
            if(ferry.isOccupiedInDirection(start, direction)){
                occupied++;
            }
        }
        return occupied;
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
