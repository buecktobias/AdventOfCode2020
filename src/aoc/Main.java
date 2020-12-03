package aoc;

import aoc.aufgabe3.Aufgabe3Solver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        aoc.aufgabe3.Tree tree = new aoc.aufgabe3.Tree();
        System.out.println(tree.isTree());
        try {
            System.out.println(Arrays.toString(Aufgabe3Solver.readFieldObjectsFromFile("test_input3")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
