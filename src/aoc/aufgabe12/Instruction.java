package aoc.aufgabe12;

public class Instruction {
    private InstructionType instructionType;
    private int parameter;
    public Instruction(InstructionType instructionType, int parameter) {
        this.instructionType = instructionType;
        this.parameter = parameter;
    }
    public Instruction(Direction direction, int parameter) {
        this.instructionType = InstructionType.valueOf(direction.name());
        this.parameter = parameter;
    }

    public InstructionType getInstructionType() {
        return instructionType;
    }

    public int getParameter() {
        return parameter;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "instructionType=" + instructionType +
                ", parameter=" + parameter +
                '}';
    }
}
