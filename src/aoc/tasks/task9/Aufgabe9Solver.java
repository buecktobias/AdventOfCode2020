package aoc.tasks.task9;

import aoc.tasks.task1.Aufgabe1;
import aoc.helper.Input;

import java.util.LinkedList;
import java.util.List;

public class Aufgabe9Solver {

    public static List<Long> getFromTo(int from, int to, List<Long> integerList ) {
        return integerList.subList(from, to);
    }

    public static long getSumFromTo(int from, int to, List<Long> longList){
        List<Long> subList = getFromTo(from, to, longList);
        long sum = 0;
        for (Long l : subList) {
            sum += l;
        }
        return sum;
    }

    public static List<Long> getSubListSum(List<Long> longList, long sum){
        for (int i = 0; i < longList.size(); i++) {
            for (int j = 0; j < i-1; j++) {
                if(getSumFromTo(j, i+1, longList) == sum){
                    return getFromTo(j, i+1, longList);
                }
            }

        }
        return new LinkedList<>();
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

    public static long getMaxNumber(List<Long> longList){
        if(longList.size() == 0){
            return -1;
        }

        long max = longList.get(0);
        for (Long aLong : longList) {
            if (aLong > max){
                max = aLong;
            }
        }
        return max;
    }

    public static long getMinNumber(List<Long> longList){
        if(longList.size() == 0){
            return -1;
        }

        long min = longList.get(0);
        for (Long aLong : longList) {
            if (aLong < min){
                min = aLong;
            }
        }
        return min;
    }

    public static long solvePart1(String filename, int last){
        List<Long> integerList = Input.getInputAsLongs(filename);
        return getLastNumberNotCorrect(integerList, last);
    }

    public static long solvePart2(String filename, int last){
        List<Long> integerList = Input.getInputAsLongs(filename);
        long sum = getLastNumberNotCorrect(integerList, last);
        List<Long> subList = getSubListSum(integerList, sum);
        long min = getMinNumber(subList);
        long max = getMaxNumber(subList);
        return min + max;
    }
}
