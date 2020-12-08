package aoc.aufgabe8;

import java.util.LinkedList;
import java.util.List;

public class Program {
    private List<Integer> alreadyExecuted;
    private List<Command> commands;
    private int accumulator;
    private int position;
    public Program(){
        commands = new LinkedList<>();
        alreadyExecuted = new LinkedList<>();
        position = 0;
        accumulator = 0;
    }

    public void run(){
        int lastPosition;
        while(!hasExecuted(position) && position != this.commands.size()){
            this.executedCommand();
        }
    }

    public boolean hasTerminated(){
        return this.position == this.commands.size();
    }

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public boolean hasExecuted(int position){
        return alreadyExecuted.contains(position);
    }

    public void executedCommand(){
        int lastPosition = this.position;
        Command cmd = this.commands.get(this.position);
        cmd.execute(this);
        this.alreadyExecuted.add(lastPosition);
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Program{" +
                "commands=" + commands +
                ", accumulator=" + accumulator +
                ", position=" + position +
                '}';
    }
}
