package aoc;


import aoc.aufgabe10.Aufgabe10Solver;
import aoc.aufgabe11.Aufgabe11Solver;
import aoc.aufgabe11.Ferry;
import aoc.aufgabe11.Seat;
import aoc.aufgabe12.*;
import aoc.aufgabe4.Aufgabe4Solver;
import aoc.aufgabe5.Aufgabe5Solver;
import aoc.aufgabe6.Aufgabe6Solver;
import aoc.aufgabe7.Aufgabe7Solver;
import aoc.aufgabe8.Aufgabe8Solver;
import aoc.aufgabe9.Aufgabe9Solver;
import aoc.helper.Vector2D;
import aoc.helper.graph.DirectedWeightedGraph;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Instruction> instructionList = Aufgabe12Solver.getInput("input/input12");

        Ship ship = new ShipPart2();

        ship.executeInstructions(instructionList);

        System.out.println(ship.getManhattanDistance());
    }
}