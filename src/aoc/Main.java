package aoc;


import aoc.aufgabe10.Aufgabe10Solver;
import aoc.aufgabe11.Aufgabe11Solver;
import aoc.aufgabe11.Ferry;
import aoc.aufgabe11.Seat;
import aoc.aufgabe12.Aufgabe12Solver;
import aoc.aufgabe12.Instruction;
import aoc.aufgabe12.InstructionType;
import aoc.aufgabe12.Ship;
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
        Vector2D vec = new Vector2D(10,-4);
        try {
            System.out.println(vec.rotate(-270));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Instruction> instructionList = Aufgabe12Solver.getInput("input/input12");

        Ship ship = new Ship();

        ship.executeInstructions(instructionList);

        System.out.println(ship.getManhattanDistance());
    }
}