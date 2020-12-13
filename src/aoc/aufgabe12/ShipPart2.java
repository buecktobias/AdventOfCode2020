package aoc.aufgabe12;

import aoc.helper.Vector2D;

public class ShipPart2 extends Ship{

    public ShipPart2() {
        super();
        waypoint = new Vector2D(10,-1);
    }

    protected Vector2D waypoint;

    @Override
    public void rotate(int degrees) throws Exception {
        this.waypoint = this.waypoint.rotate(degrees);
    }

    @Override
    public void move(Direction direction, int distance) {
        Vector2D moveVector = direction.getDirectionVector().scalarMultiplication(distance);
        this.waypoint = this.waypoint.addVector(moveVector);
    }

    @Override
    public void executeForward(Instruction instruction) {
        assert instruction.getInstructionType() == InstructionType.FORWARD;
        Vector2D moveVector = this.waypoint.scalarMultiplication(instruction.getParameter());
        this.position = this.position.addVector(moveVector);
    }
}
