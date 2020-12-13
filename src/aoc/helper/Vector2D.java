package aoc.helper;

public class Vector2D {
    private final int x;
    private final int y;

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
    public int getManhattanDistance(){
        return Math.abs(this.getX()) + Math.abs(this.getY());
    }

    public Vector2D scalarMultiplication(int scalar){
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
