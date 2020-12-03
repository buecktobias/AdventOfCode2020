package aoc.aufgabe3;

public class Player {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public Player(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void move(){
        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }
}
