package aoc.aufgabe11;

import java.util.Arrays;
import java.util.List;

public class Directions {

    public static List<Vector2D> getDirections(){
        return Arrays.asList(
                new Vector2D(-1, -1),
                new Vector2D(-1, 0),
                new Vector2D(-1, 1),
                new Vector2D(0, 1),
                new Vector2D(1, 1),
                new Vector2D(1, 0),
                new Vector2D(1, -1),
                new Vector2D(0, -1));
    }
}
