package aoc.tasks.task6;

import aoc.helper.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Task6Solver {
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

    public static HashSet<Character> getHashSet(String string){
        List<Character> characterList = stringToCharacterList(string);
        HashSet<Character> hashSet= new HashSet<Character>(characterList);
        return hashSet;
    }

    public static int getAmountUniques(String string){
        return getHashSet(string).size();
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

    public static String[][] getGroupsAs2D(String filename){
        String[] groups = getGroups(filename);
        String[][] groups2d = new String[groups.length][];
        for (int i = 0; i < groups.length; i++) {
            groups2d[i] = groups[i].split("\n");
        }
        return groups2d;
    }

    public static int countGroupPart2(String[] group){
        HashSet<Character> all = getHashSet(group[0]);
        for (String s : group) {
            all.retainAll(getHashSet(s));
        }
        return all.size();
    }

    public static int summedCountGroupPart2(String[][] groups){
        int sum = 0;
        for (String[] group : groups) {
            sum += countGroupPart2(group);
        }
        return sum;
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

    public static int solvePart2(String filename){
        String[][] groups = getGroupsAs2D(filename);
        return summedCountGroupPart2(groups);
    }
}
