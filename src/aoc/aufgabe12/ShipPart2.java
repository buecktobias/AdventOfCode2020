package aoc.aufgabe12;

import aoc.helper.Vector2D;

public class ShipPart2 extends Ship{

    public ShipPart2() {
        waypoint = new Vector2D(10,-1);
    }

    protected Vector2D waypoint;

    @Override
    public void rotate(int degrees) throws Exception {
        super.rotate(degrees);
    }

    @Override
    public void move(Direction direction, int distance) {
        super.move(direction, distance);
    }

    @Override
    public void executeForward(Instruction instruction) {
        super.executeForward(instruction);
    }
}
