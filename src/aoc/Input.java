package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
}
