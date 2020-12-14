package aoc.tasks.task8;

public class AccumulatorCommand extends Command{
    public AccumulatorCommand(int argument) {
        super(argument);
    }

    @Override
    public void execute(Program byProgram) {
        byProgram.setAccumulator(byProgram.getAccumulator() + this.getArgument());
        byProgram.setPosition(byProgram.getPosition() + 1);
    }

    @Override
    public String toString() {
        return "AccumulatorCommand{ " + this.getArgument() + " }";
    }
}
