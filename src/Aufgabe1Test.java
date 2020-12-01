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
}