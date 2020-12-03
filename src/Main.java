import aufgabe3.Aufgabe3Solver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        aufgabe3.Tree tree = new aufgabe3.Tree();
        System.out.println(tree.isTree());
        try {
            System.out.println(Aufgabe3Solver.charToFieldObject('#'));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
