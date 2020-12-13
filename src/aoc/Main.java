package aoc;


import aoc.aufgabe10.Aufgabe10Solver;
import aoc.aufgabe11.Aufgabe11Solver;
import aoc.aufgabe11.Ferry;
import aoc.aufgabe11.Seat;
import aoc.aufgabe12.Instruction;
import aoc.aufgabe12.InstructionType;
import aoc.aufgabe12.Ship;
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
        Ship ship = new Ship();
        Instruction instruct = new Instruction(InstructionType.FORWARD, 20);
        Instruction instruct2 = new Instruction(InstructionType.LEFT, 180);
        ship.executeInstructions(Arrays.asList(instruct2, instruct));

        System.out.println(ship);
    }
}