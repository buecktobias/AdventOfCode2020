package aoc.aufgabe10;

import aoc.helper.Input;

import java.util.*;

public class Aufgabe10Solver {

    public static List<Integer> getSortedList(List<Integer> integerList){
        List<Integer> copy = new LinkedList<>(integerList);
        Collections.sort(copy);
        return copy;
    }

    public static int getDifference(List<Integer> list, int index1, int index2){
        return Math.abs(list.get(index1) - list.get(index2));
    }

    public static Map<Integer, Integer> getDifferences(List<Integer> sortedList){
        Map<Integer, Integer> differencesMap = new HashMap<>();
        differencesMap.put(0, 0);
        differencesMap.put(1, 0);
        differencesMap.put(2, 0);
        differencesMap.put(3, 0);
        for (int i = 1; i < sortedList.size(); i++) {
            int j = i-1;
            int diff = getDifference(sortedList, i, j);
            if (diff <= 3){
                differencesMap.put(diff, differencesMap.get(diff) + 1);
            }else{
                break;
            }
        }
        differencesMap.put(3, differencesMap.get(3) +1);
        return differencesMap;
    }

    public static int solvePart1(String filename){
        List<Integer> inputList = Input.getInputAsInts(filename);
        inputList.add(0);
        List<Integer> sortedList = getSortedList(inputList);
        Map<Integer, Integer> differences = getDifferences(sortedList);
        return differences.get(1) * differences.get(3);
    }
}