package aoc.aufgabe6;

import aoc.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Aufgabe6Solver {
    public static List<Character> stringToCharacterList(String string){
        List<Character> listC = new ArrayList<Character>();
        char[] characters = string.toCharArray();

        for (char c : characters) {
            listC.add(c);
        }
        return listC;
    }

    public static int summedUniques(String[] strings){
        int sum = 0;
        for (String string : strings) {
            sum += getAmountUniques(string);
        }
        return sum;
    }

    public static int getAmountUniques(String string){
        List<Character> characterList = stringToCharacterList(string);
        HashSet<Character> hashSet= new HashSet<Character>(characterList);
        return hashSet.size();
    }


    public static String deleteNewLines(String string){
        return string.replace("\n", "");
    }


    public static String[] getFormattedGroup(String filename){
        String[] strings = getGroups(filename);
        String[] formatted = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            formatted[i] = deleteNewLines(strings[i]);
        }
        return formatted;
    }

    public static String[] getGroups(String filename){
        String text = null;
        try {
            text = Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert text != null;
       return text.split("\n\n");
    }


    public static int solvePart1(String filename){
        String[] formattedGroups =  getFormattedGroup(filename);
        return summedUniques(formattedGroups);
    }
}
