package aoc.tasks.task1;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @org.junit.jupiter.api.Test
    void add() {
        int a = 5;
        int b = 6;
        assertTrue(Task1Solver.add(a,b) == 11);
        assertTrue(Task1Solver.add(-2, 3) == 1);
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        int a = 5;
        int b = 6;
        assertTrue(Task1Solver.multiply(a,b) == 30);
        assertTrue(Task1Solver.multiply(-2, 3) == -6);
    }

    @org.junit.jupiter.api.Test
    void sumIs() {
        int a = 5;
        int b = 6;
        assertTrue(Task1Solver.sumIs(a,b, 11));
        assertFalse(Task1Solver.sumIs(2,10,3));
    }

    @org.junit.jupiter.api.Test
    void isSum2020() {
        int a = 1000;
        int b = 1020;
        assertTrue(Task1Solver.isSum2020(a,b));
        assertFalse(Task1Solver.isSum2020(10, 20));
    }

    @org.junit.jupiter.api.Test
    void hasSum() {
        List<Integer> exampleList1 = Arrays.asList(1, 30, 40, 1000, 1020, 2000);
        List<Integer> exampleList2 = Arrays.asList(1, 30, 40, 1000, 2000);
        List<Integer> exampleList3 = Arrays.asList(1, 30, 40, 1000, 1020);
        List<Integer> exampleList4 = Arrays.asList(1, 3000, 1, 1010, 2000);
        assertTrue(Task1Solver.hasSum(exampleList1));
        assertFalse(Task1Solver.hasSum(exampleList2));
        assertTrue(Task1Solver.hasSum(exampleList3));
        assertFalse(Task1Solver.hasSum(exampleList4));
    }

    @org.junit.jupiter.api.Test
    void findElements() {
        List<Integer> exampleList1 = Arrays.asList(1, 30, 40, 1000, 1020, 2000);
        List<Integer> exampleList2 = Arrays.asList(1, 30, 40, 1000, 2000);
        assertTrue(Task1Solver.multiplyElements(exampleList1) == 1000 * 1020);
        assertTrue(Task1Solver.multiplyElements(exampleList2) == -1);
    }

    @org.junit.jupiter.api.Test
    void getInput() {
        String file = "input1";
        assertTrue(Task1Solver.getInput(file).contains(1977));
        assertTrue(Task1Solver.getInput(file).contains(910));
        assertTrue(Task1Solver.getInput(file).contains(1868));
    }

    @org.junit.jupiter.api.Test
    void solve() {
        assertTrue(Task1Solver.solve("test_input1") == 514579);
    }

}