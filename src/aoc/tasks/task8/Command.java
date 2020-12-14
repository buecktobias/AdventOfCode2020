package aoc.tasks.task8;

public abstract class Command {
    private int argument;

    public Command(int argument){
        this.argument = argument;
    }

    public static Command getCommand(String command, int argument){
        if (command.equals("nop")){
            return new NoOperation(argument);
        }else if(command.equals("jmp")){
            return new JumpCommand(argument);
        }else{
            return new AccumulatorCommand(argument);
        }

    }

    public abstract void execute(Program byProgram);

    public int getArgument() {
        return argument;
    }

    public void setArgument(int argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "Command{" +
                "argument=" + argument +
                '}';
    }
}
