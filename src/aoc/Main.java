package aoc;

import aoc.aufgabe3.Aufgabe3Solver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        aoc.aufgabe3.Tree tree = new aoc.aufgabe3.Tree();
        System.out.println(tree.isTree());
        try {
            System.out.println(Aufgabe3Solver.solvePart1("input3.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
