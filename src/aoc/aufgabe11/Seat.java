package aoc.aufgabe11;

import java.util.List;
import java.util.stream.Collectors;

public class Seat extends FerryObject{
    public boolean isEmpty;

    public Seat(int x, int y) {
        super(x, y);
        this.isEmpty = true;
    }


    public boolean isEmpty(){
        return isEmpty;
    }

    @Override
    public boolean isOccupied() {
        return !isEmpty;
    }

    @Override
    public FerryObject getCopy() {
        Seat newSeat = new Seat(x,y);
        newSeat.isEmpty = this.isEmpty;
        return newSeat;
    }

    @Override
    public boolean equals(Object obj) {
        Seat ferryObject = (Seat) obj;
        System.out.println("lol");
        return ferryObject.isEmpty == this.isEmpty && ferryObject.x == this.x && ferryObject.y == this.y;
    }

    @Override
    public void changeState(List<FerryObject> ferryObjectList) {
        int amountAdjacentOccupied = this.getAdjacentOccupied(ferryObjectList);
        if(!this.isOccupied() && amountAdjacentOccupied == 0){
            this.isEmpty = false;
        }else if(this.isOccupied() && amountAdjacentOccupied >= 4){
            this.isEmpty = true;
        }else {
            // Nothing
        }
    }

    @Override
    public String toString() {
        if(this.isEmpty()){
            return "L";
        }else{
            return "#";
        }
    }
}
