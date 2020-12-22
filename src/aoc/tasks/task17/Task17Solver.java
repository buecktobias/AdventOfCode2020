package aoc.tasks.task17;

import aoc.helper.Input;
import aoc.helper.Vector3D;

import java.io.IOException;

public class Task17Solver {
    public static Grid3D getInput(String filename){
        Grid3D initialGrid = new Grid3D();
        String[] lines = Input.getInputAsStringArray(filename);
        for (int y = 0; y < lines.length; y++) {
            char[] chars = lines[y].toCharArray();
            for(int x=0; x < chars.length; x++ ){
                if (chars[x] == '#'){
                    initialGrid.setCubeAtActive(new Vector3D(x,y,0));
                }
            }
        }
        return initialGrid;
    }

    public static Grid3D domultipleCycles(Grid3D grid3D, int cycles){
        Grid3D oldGrid = grid3D;
        Grid3D newGrid = new Grid3D();
        for (int i = 0; i < cycles; i++) {
            newGrid = oldGrid.nextCycle();
            oldGrid = newGrid;
        }
        return newGrid;
    }


}
