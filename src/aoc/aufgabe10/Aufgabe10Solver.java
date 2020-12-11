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

    public static int getMaxElement(Collection<Integer> list) {
        int i = 0;
        for (Integer integer : list) {
            if(integer > i){
                i = integer;
            }
        }
        return i;
    }

    public static long solvePart2(String filename){
        List<Integer> inputList = Input.getInputAsInts(filename);
        inputList.add(0);

        return getPossibleCombinations(inputList);
    }

    public static long getPossibleCombinations(List<Integer> integerList) {
        int max = getMaxElement(integerList);
        Set<Integer> uniqueNumbers = new HashSet<>(integerList);
        long possibleCombis = combinationsFrom(0, uniqueNumbers,new HashMap<Integer, Long>(), max);
        return possibleCombis;
    }

    public static long combinationsFrom(int from, Collection<Integer> uniqueNumbers, Map<Integer, Long> savedCombis, int end){
        if(savedCombis.containsKey(from)){
            return savedCombis.get(from);
        }
        long value;
        if(from == end){
            value = 1;
        }else if(!uniqueNumbers.contains(from) && from != 0){
            value = 0;
        }else{
            long combi1;
            if(savedCombis.containsKey(from + 1)){
                combi1 = savedCombis.get(from + 1);
            }else{
                combi1 = combinationsFrom(from +1, uniqueNumbers, savedCombis, end);
                savedCombis.put(from + 1, combi1);
            }
            long combi2;
            if(savedCombis.containsKey(from + 2)){
                combi2 = savedCombis.get(from + 2);
            }else{
                combi2 = combinationsFrom(from + 2, uniqueNumbers, savedCombis, end);
                savedCombis.put(from + 2, combi2);
            }

            long combi3;
            if(savedCombis.containsKey(from + 3)){
                combi3 = savedCombis.get(from + 3);
            }else{
                combi3 = combinationsFrom(from + 3, uniqueNumbers, savedCombis, end);
                savedCombis.put(from + 3, combi3);
            }


            value = combi1 + combi2 + combi3;
        }
        savedCombis.put(from, value);
        return value;
    }



}
