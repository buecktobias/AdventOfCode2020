package aoc.aufgabe9;

import aoc.aufgabe1.Aufgabe1;
import aoc.helper.Input;

import java.util.LinkedList;
import java.util.List;

public class Aufgabe9Solver {
    public static List<Long> getInput(String filename){
        List<Long> newIntegerList = new LinkedList<>();
        for (String s:Input.getInputAsStringArray(filename)){
            newIntegerList.add(Long.valueOf(s));
        }
        return newIntegerList;
    }

    public static List<Long> getFromTo(int from, int to, List<Long> integerList ) {
        return integerList.subList(from, to);
    }

    public static boolean isCorrect(int atIndex, int last, List<Long> integerList){
        if(atIndex < last){
            return true;
        }
        List<Long> integers = getFromTo(atIndex - last, atIndex, integerList);
        long number = integerList.get(atIndex);
        return Aufgabe1.hasSum(integers, number);
    }

    public static long getLastNumberNotCorrect(List<Long> integerList, int last){
        for(int i = 0; i < integerList.size();i++){
            if(!isCorrect(i, last, integerList)){
                return integerList.get(i);
            }
        }
        return -1;
    }

    public static long solvePart1(String filename, int last){
        List<Long> integerList = getInput(filename);
        return getLastNumberNotCorrect(integerList, last);
    }
}
