import static org.junit.jupiter.api.Assertions.*;

class Aufgabe1Test {

    @org.junit.jupiter.api.Test
    void add() {
        int a = 5;
        int b = 6;
        assertTrue(Aufgabe1.add(5,6) == 11);
    }
}