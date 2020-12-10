package aoc;


import aoc.aufgabe10.Aufgabe10Solver;
import aoc.aufgabe4.Aufgabe4Solver;
import aoc.aufgabe5.Aufgabe5Solver;
import aoc.aufgabe6.Aufgabe6Solver;
import aoc.aufgabe7.Aufgabe7Solver;
import aoc.aufgabe8.Aufgabe8Solver;
import aoc.aufgabe9.Aufgabe9Solver;
import aoc.helper.graph.DirectedWeightedGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> sorted = Aufgabe10Solver.getSortedList(Arrays.asList(1, 7, 2, 8, 4, 9, 1, 0, 15, 16, 17, 18, 19));
        System.out.println(Aufgabe10Solver.getDifferences(sorted));
        System.out.println(Aufgabe10Solver.solvePart1("input/input10"));
    }
}