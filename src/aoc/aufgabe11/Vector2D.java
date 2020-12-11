package aoc.aufgabe11;

public class Vector2D {
    private int x;
    private int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Vector2D addVector(Vector2D vector2D){
        return new Vector2D(this.getX() + vector2D.getX(), this.getY() + vector2D.getY());
    }
}
