import java.util.LinkedList;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Aufgabe1 implements Aufgabe {
    private static int add(int a, int b) {
        return a + b;
    }

    private static boolean sumIs(int a, int b, int sum) {
        return add(a, b) == sum;
    }

    private static boolean sumIs(int a, int b, int c, int sum) {
        return a + b + c == sum;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static boolean isSum2020(int a, int b) {
        return sumIs(a, b, 2020);
    }

    private static boolean isSum2020(int a, int b, int c) {
        return sumIs(a, b, c, 2020);
    }

    private static int multiplyElements(List<Integer> list) {
        int element1;
        int element2;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int k = i + 1; k < list.size(); k++) {
                element1 = list.get(i);
                element2 = list.get(k);
                if (isSum2020(element1, element2)) {
                    return multiply(element1, element2);
                }
            }
        }
        return -1;
    }

    private static int multiplyThreeElements(List<Integer> list) {
        int element1;
        int element2;
        int element3;

        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.size(); k++) {
                for (int l = 0; l < list.size(); l++) {
                    if (i == k || k == l || i == l) {
                        continue;
                    }
                    element1 = list.get(i);
                    element2 = list.get(k);
                    element3 = list.get(l);
                    if (isSum2020(element1, element2, element3)) {
                        return element1 * element2 * element3;
                    }
                }

            }
        }
        return -1;
    }

    private static List<Integer> getInput(String nameOfFile) {
        Path fileName = Path.of(nameOfFile);
        String actual = null;
        try {
            actual = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split("\n");
        List<Integer> listInteger = new LinkedList<>();

        for (int i = 0; i < arrOfStr.length; i++) {
            String mStr = arrOfStr[i];
            listInteger.add(Integer.valueOf(mStr));
        }
        return listInteger;
    }

    @Override
    public String solvePart1(String filename) {
        return String.valueOf(multiplyElements(getInput(filename)));
    }

    @Override
    public String solvePart2(String filename) {
        return String.valueOf(multiplyThreeElements(getInput(filename)));
    }
}
