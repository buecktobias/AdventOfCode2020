package aoc.aufgabe12;

import aoc.helper.Vector2D;

import java.util.List;

public class Ship {

    protected Vector2D position;
    protected Direction facingDirection;

    public Ship() {
        this.position = new Vector2D(0,0);
        this.facingDirection = Direction.EAST;
    }

    public Vector2D getPosition() {
        return position;
    }
    public int getManhattanDistance(){
        return this.position.getManhattanDistance();
    }

    public void rotate(Instruction instruction) throws Exception{
        InstructionType instructionType = instruction.getInstructionType();
        assert instructionType == InstructionType.LEFT || instructionType == InstructionType.RIGHT;
        switch(instructionType){
            case LEFT:
                this.rotate(-instruction.getParameter());
                break;
            case RIGHT:
                this.rotate(instruction.getParameter());
                break;
        }
    }

    public void rotate(int degrees) throws Exception{
        this.facingDirection = this.facingDirection.changeRotation(degrees);
    }

    public void move(Direction direction, int distance){
        Vector2D directionVector = direction.getDirectionVector();
        Vector2D moveVector = directionVector.scalarMultiplication(distance);
        this.position = this.position.addVector(moveVector);
    }

    public void executeInstructions(List<Instruction> instructions){
        for (Instruction instruction : instructions) {
            this.executeInstruction(instruction);
        }
    }

    public void executeForward(Instruction instruction){
        this.executeInstruction(new Instruction(this.facingDirection, instruction.getParameter()));
    }

    public void executeInstruction(Instruction instruction){
        InstructionType instructionType = instruction.getInstructionType();
        switch (instructionType){
            case LEFT: case RIGHT:
                try {
                    this.rotate(instruction);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case EAST: case WEST: case NORTH: case SOUTH:
                try {
                    this.move(instructionType.getDirection(), instruction.getParameter());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case FORWARD:
                this.executeForward(instruction);
                break;
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "position=" + position +
                ", facingDirection=" + facingDirection +
                '}';
    }
}
