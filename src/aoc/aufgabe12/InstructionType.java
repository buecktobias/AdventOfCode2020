package aoc.aufgabe12;

public enum InstructionType {
    RIGHT,
    LEFT,
    NORTH,
    SOUTH,
    EAST,
    WEST,
    FORWARD;

    public Direction getDirection(){
        return Direction.valueOf(this.name());
    }

    @Override
    public String toString() {
        return "InstructionType{}";
    }
}
