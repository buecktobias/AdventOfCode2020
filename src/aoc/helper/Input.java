package aoc.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Input {
    public static String readFile(String filename) throws IOException{
        Path filePath = Path.of(filename);
        String actual = null;
        actual = Files.readString(filePath);
        return actual;
    }

    public static String[] getInputAsStringArray(String fileName){
        String actual = null;
        try {
            actual = readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split("\n");
        return arrOfStr;
    }


    public static List<Long> getInputAsLongs(String filename){
        List<Long> newIntegerList = new LinkedList<>();
        for (String s:Input.getInputAsStringArray(filename)){
            newIntegerList.add(Long.valueOf(s));
        }
        return newIntegerList;
    }

    public static List<Integer> getInputAsInts(String filename){
        List<Integer> newIntegerList = new LinkedList<>();
        for (String s:Input.getInputAsStringArray(filename)){
            newIntegerList.add(Integer.valueOf(s));
        }
        return newIntegerList;
    }
}
