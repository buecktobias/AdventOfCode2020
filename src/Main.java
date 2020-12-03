import aufgabe3.Aufgabe3Solver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        aufgabe3.Tree tree = new aufgabe3.Tree();
        System.out.println(tree.isTree());
        try {
            System.out.println(Arrays.toString(Aufgabe3Solver.stringToFieldObjects("..#.")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
