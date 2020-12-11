package aoc;


import aoc.aufgabe10.Aufgabe10Solver;
import aoc.aufgabe11.Aufgabe11Solver;
import aoc.aufgabe11.Ferry;
import aoc.aufgabe11.Seat;
import aoc.aufgabe4.Aufgabe4Solver;
import aoc.aufgabe5.Aufgabe5Solver;
import aoc.aufgabe6.Aufgabe6Solver;
import aoc.aufgabe7.Aufgabe7Solver;
import aoc.aufgabe8.Aufgabe8Solver;
import aoc.aufgabe9.Aufgabe9Solver;
import aoc.helper.graph.DirectedWeightedGraph;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ferry ferry = Aufgabe11Solver.readInput("input/test_input11");
        System.out.println(ferry);

        System.out.println(Aufgabe11Solver.developUntilNoChange(ferry));

    }
}