package aoc.aufgabe11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Ferry {
    // erst Spalte dann Zeile x, y
    private FerryObject[][] area;

    public Ferry(FerryObject[][] area){
        this.area = area;
    }

    public Ferry getDeepCopy(){
        FerryObject[][] areaCopy = new FerryObject[this.getWidth()][this.getHeight()];
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                areaCopy[i][j] = this.area[i][j].getCopy();
            }
        }
        return new Ferry(areaCopy);
    }

    public FerryObject[][] getArea() {
        return area;
    }


    public void develop(Ferry oldFerry){
        for (int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++){
                List<FerryObject> adjacentObjects = oldFerry.getAdjacentObjects(x,y);
                this.area[x][y].changeState(adjacentObjects);
            }
        }
    }

    private int getWidth(){
        return this.area.length;
    }

    private int getHeight(){
        return this.area[0].length;
    }

    private Optional<FerryObject> getObjectAt(int xPosition, int yPosition){
        if (xPosition >= 0 && xPosition < this.getWidth() && yPosition >= 0 && yPosition < this.getHeight()){
            return Optional.of(this.area[xPosition][yPosition]);
        }
        return Optional.empty();
    }
    public List<FerryObject> getAdjacentObjects(int xPosition, int yPosition){
        List<FerryObject> adjacentObjects = new LinkedList<>();
        int x_0 = xPosition - 1;
        int x_1 = xPosition;
        int x_2 = xPosition + 1;
        int y_0 = yPosition - 1;
        int y_1 = yPosition;
        int y_2 = yPosition + 1;
        int[][] allAdjacentPositions = new int[][] {
                {x_0, y_0},
                {x_0, y_1},
                {x_0, y_2},
                {x_1, y_2},
                {x_2, y_2},
                {x_2, y_1},
                {x_2, y_0},
                {x_1, y_0}
        };
        for (int[] allAdjacentPosition : allAdjacentPositions) {
            int x = allAdjacentPosition[0];
            int y = allAdjacentPosition[1];
            Optional<FerryObject> ferryObject = this.getObjectAt(x, y);
            ferryObject.ifPresent(adjacentObjects::add);
        }
        return adjacentObjects;
    }

    @Override
    public boolean equals(Object obj) {
        Ferry other = (Ferry) obj;
        for(int x = 0; x < this.getWidth(); x++){
            for (int i = 0; i < this.getHeight(); i++) {
                if(!this.area[x][i].equals(other.getArea()[x][i])){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ferry{\n");
        for(int y=0; y < this.getHeight(); y++){
            for (int x = 0; x < this.getWidth(); x++) {
               stringBuilder.append(this.area[x][y].toString());
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
