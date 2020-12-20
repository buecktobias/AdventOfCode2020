package aoc.tasks.task15;

import java.util.*;

public class Task15Solver {
    public static List<Integer> getInput(){
        List<Integer> integerList = new LinkedList<>();
        integerList.add(15);
        integerList.add(5);
        integerList.add(1);
        integerList.add(4);
        integerList.add(7);
        integerList.add(0);
        return integerList;
    }
    public static List<Integer> getTestInput(){
        List<Integer> integerList = new LinkedList<>();
        integerList.add(0);
        integerList.add(3);
        integerList.add(6);
        return integerList;
    }

    public static int getNextNumber(List<Integer> integerList, Map<Integer, Integer> savedValues){
        int lastNumber = integerList.get(integerList.size() - 1);
        int result;
        if(!savedValues.containsKey(lastNumber)){
            result = 0;

        }else{
            result = integerList.size() - savedValues.get(lastNumber) - 1;
        }
        savedValues.put(lastNumber, integerList.size() -1);
        return result;
    }


    public static List<Integer> addNextNumbersUntil(List<Integer> startNumbers, int until){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < startNumbers.size() - 1; i++) {
            map.put(startNumbers.get(i), i);
        }

        while(startNumbers.size() < until){
            int nextNumber = getNextNumber(startNumbers, map);
            startNumbers.add(nextNumber);
        }
        return startNumbers;
    }

    public static int solvePart1(){
        List<Integer> myList = getInput();
        addNextNumbersUntil(myList, 30000000);
        System.out.println(myList.get(30000000-1));
        return 0;
    }
}
