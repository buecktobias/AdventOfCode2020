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

    public static int getMaxElement(List<Integer> list) {
        int i = 0;
        for (Integer integer : list) {
            if(integer > i){
                i = integer;
            }
        }
        return i;
    }

    public static int solvePart2(String filename){
        List<Integer> inputList = Input.getInputAsInts(filename);
        inputList.add(0);

        return getPossibleCombinations(inputList);
    }

    public static int getPossibleCombinations(List<Integer> integerList) {
        int max = getMaxElement(integerList);
        Set<Integer> uniqueNumbers = new HashSet<>(integerList);
        int possibleCombis = combinationsFrom(0, uniqueNumbers, max);
        return possibleCombis;
    }

    public static int combinationsFrom(int from, Set<Integer> uniqueNumbers, int end){
        if(from == end){
            return 1;
        }else if(!uniqueNumbers.contains(from) && from != 0){
            return 0;
        }else{
            return combinationsFrom(from + 1, uniqueNumbers, end) + combinationsFrom(from + 2, uniqueNumbers, end) + combinationsFrom(from + 3, uniqueNumbers, end);
        }
    }



}
