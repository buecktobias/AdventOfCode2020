package aoc.aufgabe8;

public class JumpCommand extends Command{
    public JumpCommand(int argument) {
        super(argument);
    }

    @Override
    public void execute(Program byProgram) {
        byProgram.setPosition(byProgram.getPosition() + this.getArgument());
    }

    @Override
    public String toString() {
        return "JumpCommand{ " + this.getArgument() + " }";
    }
}
