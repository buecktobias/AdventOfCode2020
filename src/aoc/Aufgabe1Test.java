package aoc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Aufgabe1Test {

    @org.junit.jupiter.api.Test
    void add() {
        int a = 5;
        int b = 6;
        assertTrue(Aufgabe1.add(a,b) == 11);
        assertTrue(Aufgabe1.add(-2, 3) == 1);
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        int a = 5;
        int b = 6;
        assertTrue(Aufgabe1.multiply(a,b) == 30);
        assertTrue(Aufgabe1.multiply(-2, 3) == -6);
    }

    @org.junit.jupiter.api.Test
    void sumIs() {
        int a = 5;
        int b = 6;
        assertTrue(Aufgabe1.sumIs(a,b, 11));
        assertFalse(Aufgabe1.sumIs(2,10,3));
    }

    @org.junit.jupiter.api.Test
    void isSum2020() {
        int a = 1000;
        int b = 1020;
        assertTrue(Aufgabe1.isSum2020(a,b));
        assertFalse(Aufgabe1.isSum2020(10, 20));
    }

    @org.junit.jupiter.api.Test
    void hasSum() {
        List<Integer> exampleList1 = Arrays.asList(1, 30, 40, 1000, 1020, 2000);
        List<Integer> exampleList2 = Arrays.asList(1, 30, 40, 1000, 2000);
        List<Integer> exampleList3 = Arrays.asList(1, 30, 40, 1000, 1020);
        List<Integer> exampleList4 = Arrays.asList(1, 3000, 1, 1010, 2000);
        assertTrue(Aufgabe1.hasSum(exampleList1));
        assertFalse(Aufgabe1.hasSum(exampleList2));
        assertTrue(Aufgabe1.hasSum(exampleList3));
        assertFalse(Aufgabe1.hasSum(exampleList4));
    }

    @org.junit.jupiter.api.Test
    void findElements() {
        List<Integer> exampleList1 = Arrays.asList(1, 30, 40, 1000, 1020, 2000);
        List<Integer> exampleList2 = Arrays.asList(1, 30, 40, 1000, 2000);
        assertTrue(Aufgabe1.multiplyElements(exampleList1) == 1000 * 1020);
        assertTrue(Aufgabe1.multiplyElements(exampleList2) == -1);
    }

    @org.junit.jupiter.api.Test
    void getInput() {
        String file = "input1.txt";
        assertTrue(Aufgabe1.getInput(file).contains(1977));
        assertTrue(Aufgabe1.getInput(file).contains(910));
        assertTrue(Aufgabe1.getInput(file).contains(1868));
    }

    @org.junit.jupiter.api.Test
    void solve() {
        assertTrue(Aufgabe1.solve("test_input") == 514579);
    }

}