package aoc.aufgabe11;

import aoc.helper.Input;

public class Aufgabe11Solver {
    public  static Ferry readInput(String filename){
        String[] lines = Input.getInputAsStringArray(filename);
        FerryObject[][] area = new FerryObject[lines[0].length()][lines.length];
        for (int i = 0; i < lines[0].length() ; i++) {
            for (int j = 0; j < lines.length; j++) {
                char c = lines[j].toCharArray()[i];
                if (c == 'L'){
                    area[i][j] = new Seat(i, j);
                }else{
                    area[i][j] = new Floor(i, j);
                }
            }
        }
        return new Ferry(area);
    }

   public static Ferry develop(Ferry oldFerry){
        Ferry newFerry = oldFerry.getDeepCopy();
        newFerry.develop(oldFerry);
        return newFerry;
   }

   public static Ferry developUntilNoChange(Ferry startFerry){
        Ferry oldFerry = startFerry;
        Ferry newFerry = new Ferry(new FerryObject[1][1]);
        boolean ferrysEqual = false;

        while(!ferrysEqual){
            newFerry = develop(oldFerry);
            System.out.println(newFerry);
            ferrysEqual = oldFerry.equals(newFerry);
            oldFerry = newFerry;
        }
        return newFerry;
   }


}