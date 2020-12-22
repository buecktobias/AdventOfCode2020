package aoc;


import aoc.helper.Vector3D;
import aoc.tasks.task14.*;
import aoc.tasks.task15.Task15Solver;
import aoc.tasks.task16.Task16Solver;
import aoc.tasks.task16.TicketField;
import aoc.tasks.task17.Grid3D;
import aoc.tasks.task17.Grid4D;
import aoc.tasks.task17.Task17Solver;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grid4D grid = Task17Solver.getInput2("input/task17/input");
        System.out.println(Task17Solver.domultipleCycles2(grid, 6).getAmountActive());
        // System.out.println(Task16Solver.getAllCorrectValues(allTicketFields));
        // System.out.println(Task16Solver.getAllTicketValues("input/task16/test_input"));
    }
}