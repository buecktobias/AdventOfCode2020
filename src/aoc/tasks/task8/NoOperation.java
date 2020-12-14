package aoc.tasks.task8;

public class NoOperation extends Command{
    public NoOperation(int argument) {
        super(argument);
    }

    @Override
    public void execute(Program byProgram) {
        byProgram.setPosition(byProgram.getPosition() + 1);
    }

    @Override
    public String toString() {
        return "NoOperation{ " + this.getArgument()  +" }";
    }
}
