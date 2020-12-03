package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Input {
    public static String[] getInputAsStringArray(String fileName){
        Path filePath = Path.of(fileName);
        String actual = null;
        try {
            actual = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split("\n");
        return arrOfStr;
    }
}
